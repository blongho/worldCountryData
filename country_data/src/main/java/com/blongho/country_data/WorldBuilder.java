/*
 * Copyright (c) 2019 Bernard Che Longho (blongho02@gmail.com)
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
 * @file WorldBuilder.java
 * @author Bernard Che Longho (blongho02@gmail.com)
 * <br> A class to load all the flags and countries in a map
 *   <br> This eases the access of flag when the country
 *   alpha2 or alpha3  or the numeric codes are known<br> This class is accessible only to the package
 * @since 2019-02-28
 */

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/**
 *
 */
final class WorldBuilder {
	private static final String TAG = "WorldBuilder";
	private static ArrayList<Country> countryAndFlag = new ArrayList<>(); //
	// {Country + flag + currency}
	private static Map<String, Integer> flagMap = new ConcurrentHashMap<>();
	// {alpha2, mapImage}
	private static List<Currency> currencyList = new ArrayList<>(); // List of
	// currencies
	private static Country[] countries; // sets its value in getCountries()
	private static Map<String, Currency> currencyMap = new ConcurrentHashMap<>(); // {alpha2, Currency}
	private static volatile WorldBuilder instance;
	private static int globe; // The image of the globe
	private Context context; // The application context

	private WorldBuilder(Context ctx) {
		context = ctx;
		//Toast.makeText(ctx, R.string.initilizing, Toast.LENGTH_SHORT).show();
		globe = R.drawable.globe;
		getCountries();
		loadCurrencies();
		loadCountryFlagMap();
		addFlagWithOtherCountryAttributes();
		Toast.makeText(context, R.string.initialized, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Read all countries from file
	 */
	private void getCountries() {
		final String values = AssetsReader.readFromAssets(context, "com.blongho.country_data.countries.json");
		Gson gson = new Gson();
		countries = gson.fromJson(values, Country[].class);
	}

	/**
	 * Load the currencies from com.blongho.country_data.currencies.json
	 */
	private void loadCurrencies() {
		final String currencyArray = AssetsReader.readFromAssets(context, "com.blongho.country_data.currencies.json");
		Gson       gson       = new Gson();
		Currency[] currencies = gson.fromJson(currencyArray, Currency[].class);
		for (final Currency currency : currencies) {
			currencyList.add(currency);
			currencyMap.put(currency.getCountry().toLowerCase(), currency);
		}
	}

	/**
	 * Load the countries and their flags in a Map container
	 * <br>
	 * Each country is flag is mapped with the country alpha2 and alpha3 codes
	 */
	private void loadCountryFlagMap() {
		for (final Country country : countries) {
			if (country.getAlpha2().equalsIgnoreCase("do")) { // do was not allowed as a drawable so was renamed to
				// dominican
				flagMap.put(country.getAlpha2().toLowerCase(), R.drawable.dominican);
			}
			else {
				final String resource = "drawable/" + country.getAlpha2().toLowerCase();

				int countryFlag = context.getResources().getIdentifier(resource, null, context.getPackageName());
				flagMap.put(country.getAlpha2().toLowerCase(), countryFlag);

			}
		}
		flagMap.put("globe", R.drawable.globe);
	}

	/**
	 * Add the iso numeric code, alpha3 and country names as keys in the
	 * mapFlag
	 * This allows the use of this library by other languages other than the
	 * English language A flag can be gotten now but simple called
	 * WorldBuilder.of(numericCode)
	 */
	private void addFlagWithOtherCountryAttributes() {
		for (Country c : countries) {
			final Currency currency = currencyMap.get(c.getAlpha2());
			//Log.e(TAG, "run: " + c.toString());
			final int flag = of(c.getAlpha2());
			if (flag != globe) {
				addFlag(c, flag);
				countryAndFlag.add(Country.from(c.getName(), c.getAlpha2(), c.getAlpha3(), flag, c.getId(), currency));
			}
			else {
				addFlag(c, globe);
				countryAndFlag.add(Country.from(c.getName(), c.getAlpha2(), c.getAlpha3(), globe, c.getId(),
				                                currency));
			}
		}
	}

	/**
	 * Get the flag of a country
	 *
	 * @param countryAttribute the 2  or 3 letter representation of the country
	 *                         {se|SE|SWE|swe} are all valid entries for a
	 *                         Swedish flag
	 *
	 * @return the id of the flag resource or -1 if the iso alpha2 or iso
	 * alpha3
	 *   is not correct if there is no entry in the flag container with that
	 *   identify.
	 *   <p>
	 *   Note: If the values are correct and you still do not get the flag,
	 *   create an issue and this will be resolved as soon as possible.
	 */
	private static int of(@NonNull final String countryAttribute) {
		final Integer flag = flagMap.get(countryAttribute.toLowerCase());
		return flag == null ? globe : flag;
	}

	/**
	 * Add another country flag to the list of flags
	 *
	 * @param country       The country for which the flag is to be added
	 * @param imageResource the image resource <br>
	 *                      This should be a drawable resource
	 */
	private static void addFlag(@NonNull final Country country, @DrawableRes @NonNull final Integer imageResource) {
		flagMap.put(country.getAlpha2().toLowerCase(), imageResource);
		flagMap.put(country.getName().toLowerCase(), imageResource);
		flagMap.put(country.getId(), imageResource);
		flagMap.put(country.getAlpha3().toLowerCase(), imageResource);
	}

	/**
	 * Get an instance of this class<br> This is a thread-safe singleton of the
	 * class. <br> Once called, all the flag resources are loaded and all
	 * countries are assigned their flags. Calling this more than once has not
	 * benefit.
	 *
	 * @param ctx The application context (getApplicationContext())
	 *
	 * @return An instance of this class
	 */
	@AnyThread
	static WorldBuilder getInstance(Context ctx) {
		if (instance != null) return instance;
		synchronized (WorldBuilder.class) {
			if (instance == null) {
				instance = new WorldBuilder(ctx);
			}
		}
		return instance;
	}

	/**
	 * Get the countries with their flags loaded
	 *
	 * @return An unmodifiable uArrayList with all countries and their flags or
	 *   empty list
	 */
	@AnyThread
	static List<Country> allCountriesAndFlags() {
		return instance != null && !countryAndFlag.isEmpty() ? Collections.unmodifiableList(countryAndFlag) :
		  Collections.<Country>emptyList();
	}

	/**
	 * Get the map with flags and their country attributes
	 *
	 * @return an unmodifiable Map<countryIdentifier, mapID> <br> or an empty
	 *   map if the getInstance() has not been called  or if the flagMap is
	 *   empty
	 */
	static Map<String, Integer> getFlagMap() {
		return instance != null && !flagMap.isEmpty() ? Collections.unmodifiableMap(flagMap) :
		  Collections.<String, Integer>emptyMap();
	}

	/**
	 * Get the currency map
	 *
	 * @return Get the list of currencies
	 */
	static List<Currency> currencyList() {
		return Collections.unmodifiableList(currencyList);
	}

	/**
	 * The Image of the globe
	 * @return The globe as a drawable resource
	 */
	static int globe() {
		return globe;
	}

}

