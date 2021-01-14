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

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blongho.country_data.exception.CountryDataException;
import java.util.List;

/**
 * The World knows all the countries and their name, alpha2, alpha3, numeric code and flag. <br> If
 * a country does not exist or is at least not formally recognized, that country will be <br>
 * represented as Earth with flag that of the globe
 * <b>Note: <i>The country data contained here is valid as of 2021-01-12 08:30 from
 * https://www.geonames.org/countries/</i></b>
 *
 * @author Bernard Che Longho (blongho)
 * @since 2021-01-12 Adds method to get countries from continent
 */
public final class World {

  private static WorldData instance = null;

  /* No default constructor*/
  private World() {
  }

  /**
   * Initialize the world, just as it is today with all its countries and flags
   *
   * @param context The context where this object is called (getAppicationContext)
   */
  public static void init(final Context context) {
    instance = WorldData.getInstance(context);
  }

  /**
   * Get the flag of a country using the numeric code of the country
   *
   * @param countryCode The numeric code of the country
   * @return An image resource representing the country flag or the image of the globe
   */
  public static int getFlagOf(final int countryCode) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return getFlagOf(String.valueOf(countryCode));
  }

  /**
   * Get the flag of a country
   *
   * @param countryIdentifier the 2  or 3 letter representation of the country
   *                          <br> e.g {se|SE|SWE|swe} are all valid entries
   *                          for a Swedish flag
   * @return the id of the flag resource or id of globe image if the <br> iso alpha2 or iso alpha3
   * is not correct or if  there is no <br> entry in the flag container with that identify.
   * <p>
   * Note: If the values are correct and you still do not get the flag, create an issue and this
   * will be resolved as soon as possible.
   */
  public static int getFlagOf(final String countryIdentifier) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    if (countryIdentifier.isEmpty()) {
      return getWorldFlag();
    }
    return WorldData.flagFromCountry(countryIdentifier);
  }

  /**
   * Get the image of the globe directly rather than querying World.getFlagOf("globe")
   *
   * @return The image of the globe as we know it today
   */
  public static int getWorldFlag() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldData.globe();
  }

  /**
   * Get a country from its numeric code
   *
   * @param numericCode The country's numeric code
   * @return A country a country with any of the attributes or a Earth
   */
  public static Country getCountryFrom(final int numericCode) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return getCountryFrom(String.valueOf(numericCode));
  }

  /**
   * Get a country from any of its identifiers
   *
   * @param countryIdentifier The country name, alpha2 or alpha3 values, case insensitive
   * @return A country a country with any of the attributes or a Earth
   */
  public static Country getCountryFrom(final String countryIdentifier) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldData.countryFrom(countryIdentifier);
  }

  /**
   * Get a list of all the countries with their flags
   *
   * @return List of all the countries. <br> Attempting to modify this list invokes an
   * com.blongho.country_data.exception and your app will crash.
   */
  public static List<Country> getAllCountries() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldData.countries();
  }

  /**
   * Return all the currencies of the world
   *
   * @return The currencies of the world {alpha2, currencyName, currencyCode, currencySymbol}
   */
  public static List<Currency> getAllCurrencies() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldData.currencies();
  }

  /**
   * Get Countries from a continent
   *
   * @param continent a {@link Continent}
   * @return list of countries in the continent specified.
   * <p>If null is passed, then {@link World#getAllCountries()} is returned</p>
   */
  public static List<Country> getCountriesFrom(@Nullable final Continent continent) {
    return WorldData.countriesFrom(continent);
  }

  /**
   * Get the current version of the library
   *
   * @return The current library version
   */
  public static String version() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldData.CURRENT_VERSION;
  }

  /**
   * An Enum to hold the different continents
   */
  public enum Continent {
    AFRICA("Africa"),
    EUROPE("Europe"),
    ASIA("Asia"),
    OCEANA("Oceania"),
    SOUTH_AMERICA("South America"),
    NORTH_AMERICA("North America"),
    ANTARTICA("Antarctica");
    private final String name;

    Continent(final String continent) {
      this.name = continent;
    }

    public String getName() {
      return name;
    }

    @Override
    @NonNull
    public String toString() {
      return name;
    }
  }
}
