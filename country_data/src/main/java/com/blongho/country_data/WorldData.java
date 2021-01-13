/*
 * MIT License
 *
 * Copyright (c) 2019 - 2021 Bernard Longho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.blongho.country_data;
/**
 * @author Bernard Che Longho (blongho)
 * @brief A class to load all the flags and countries in a map
 * <br> This eases the access of flag when the country
 * alpha2 or alpha3  or the numeric codes are known<br> This class is accessible only to the
 * package
 * @since 2019-11-15 Refactored class and removes many unnecessary variables.
 * @since 2020-02-29 Changes classname from WorldBuilder to WorldData. *Builder is misleading since
 * this class does not follow th Builder pattern
 * @since 2021-01-12 Filters countries to exclude data with null values
 */

import android.content.Context;
import androidx.annotation.Nullable;
import com.blongho.country_data.World.Continent;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class WorldData {

  public final static String CURRENT_VERSION = "1.5.1";
  private static final Map<String, Currency> currencyMap = new HashMap<>(); // {alpha2, Currency}
  private static final Map<Country, Integer> countryFlagMap = new HashMap<>();
  private static WorldData instance;
  private static Country universe;

  private WorldData(final Context ctx) {
    loadAllData(ctx);
  }

  /**
   * Get an instance of this class<br> This is a thread-safe singleton of the class. <br> Once
   * called, all the flag resources are loaded and all countries are assigned their flags. Calling
   * this more than once has not benefit.
   *
   * @param ctx The application context (getApplicationContext())
   * @return An instance of this class
   */

  static WorldData getInstance(Context ctx) {
    if (instance != null) {
      return instance;
    }
    synchronized (WorldData.class) {
      if (instance == null) {
        instance = new WorldData(ctx);
      }
    }
    return instance;
  }

  /**
   * Load the countries and their flags in a Map container
   * <br>
   * Each country is flag is mapped with the country alpha2 and alpha3 codes
   */
  private void loadAllData(Context context) {
    int countryFlag;
    Country[] countries = loadCountries(context);

    loadCurrencies(context);

    for (final Country country : countries) {
      // do was not allowed as a drawable so was renamed to dominican
      if (country.getAlpha2().equalsIgnoreCase("do")) {
        countryFlag = R.drawable.dominican;

      } else {
        final String resource = "drawable/" + country.getAlpha2().toLowerCase();
        countryFlag = context.getResources()
            .getIdentifier(resource, null, context.getPackageName());
      }
      country.setFlagResource(countryFlag);
      country.setCurrency(currencyMap.get(country.getAlpha2().toLowerCase()));
      if (isValid(country)) {
        countryFlagMap.put(country, countryFlag);
      }
      if (country.getAlpha2().equalsIgnoreCase("xx")) {
        universe = country;
        universe.setFlagResource(globe());
        countryFlagMap.put(universe, globe());
      }
    }
  }

  /**
   * Read all countries from file
   */
  private Country[] loadCountries(Context context) {
    final String values = AssetsReader.readFromAssets(context,
        R.raw.com_blongho_country_data_countries);
    Gson gson = new Gson();
    return gson.fromJson(values, Country[].class);
  }

  /**
   * Load the currencies from com_blongho_country_data_currencies.json
   */
  private void loadCurrencies(Context context) {
    final String currencyArray = AssetsReader.readFromAssets(context,
        R.raw.com_blongho_country_data_currencies);
    Gson gson = new Gson();
    final Currency[] currencies = gson.fromJson(currencyArray, Currency[].class);
    for (final Currency currency : currencies) {
      if (isValid(currency)) {
        currencyMap.put(currency.getCountry().toLowerCase(), currency);
      }
    }
  }

  /**
   * The Image of the globe
   *
   * @return The globe as a drawable resource
   */
  static int globe() {
    return R.drawable.globe;
  }


  /* package */
  static List<Currency> currencies() {
    List<Currency> currencyList = new ArrayList<>(currencyMap.values());
    Collections.sort(currencyList, new Comparator<Currency>() {
      @Override
      public int compare(final Currency o1, final Currency o2) {
        return o1.getCountry().compareTo(o2.getCountry());
      }
    });
    return currencyList;
  }

  /* package */
  static List<Country> countries() {
    List<Country> countryList = new ArrayList<>(countryFlagMap.keySet());
    Collections.sort(countryList, new Comparator<Country>() {
      @Override
      public int compare(final Country o1, final Country o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
      }
    });
    return countryList;
  }

  /**
   * Get the flag of a country using any of the country attributes
   *
   * @param countryIdentifier (alpha2, alpha3, country name, or numeric code)
   * @return flag resource
   */
  static int flagFromCountry(final String countryIdentifier) {
    if (countryIdentifier.equalsIgnoreCase("xx")
        || countryIdentifier.equalsIgnoreCase("XXX")
        || countryIdentifier.equalsIgnoreCase("world")
        || countryIdentifier.equalsIgnoreCase("globe")) {
      return globe();
    }
    for (Country country : countryFlagMap.keySet()) {
      if (country.hasProperty(countryIdentifier)) {
        return country.getFlagResource();
      }
    }
    return globe();
  }

  static Country countryFrom(String countryIdentifier) {
    for (Country country : countryFlagMap.keySet()) {
      if (country.hasProperty(countryIdentifier)) {
        return country;
      }
    }
    return universe;
  }

  private boolean isValid(final Country country) {
    return country != null && country.getCurrency() != null && country.getContinent() != null
        && country.getName() != null;
  }

  private boolean isValid(final Currency currency) {
    return currency != null && currency.getSymbol() != null && currency.getName() != null
        && currency.getCode() != null;
  }

  static List<Country> countriesFrom(@Nullable final Continent continent) {
    List<Country> allCountries = countries();
    if (continent == null) {
      return allCountries;
    } else {
      List<Country> filtered = new ArrayList<>();
      for (final Country country : allCountries) {
        if (country.getContinent().equalsIgnoreCase(continent.getName())) {
          filtered.add(country);
        }
      }
      return filtered;
    }
  }
}

