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
 * <br> A class to load all the flags and coutries_file in a map
 * <br> This eases the access of flag when the country
 * alpha2 or alpha3  or the numeric codes are known<br> This class is accessible only to the package
 *
 * @file WorldBuilder.java
 * @author Bernard Che Longho (blongho02@gmail.com)
 * @since 2019-05-25
 */

import android.app.Application;

import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

/**
 * The WorldBuilder reads everything from the assets and prepares them for the World
 */
final class WorldBuilder {
	private final static Executor executor = Executors.newCachedThreadPool();
	static int globe = R.drawable.globe; // The image of the globe
	private static ArrayList<Country> countryAndFlag = new ArrayList<>(); //  {Country + flag + currency}
	private static Map<String, Integer> flagMap = new ConcurrentHashMap<>(); // {alpha2, mapImage}
	private static Country[] countries; // sets its value in loadCountries()
	private static Map<String, Currency> currencyMap = new ConcurrentHashMap<>(); // {alpha2, Currency}
	private static Map<String, CountryExtras> countryExtrasMap = new ConcurrentHashMap<>();
	private static volatile WorldBuilder instance;
	private Application context; // The application context
	private ExecutorCompletionService<String> countryService = new ExecutorCompletionService<>(executor);
	private ExecutorCompletionService<String> currencyService = new ExecutorCompletionService<>(executor);
	private ExecutorCompletionService<String> countryExtraService = new ExecutorCompletionService<>(executor);

	private WorldBuilder(Application ctx) {
		context = ctx;
		countryService.submit(new AssetsReader(context, R.raw.countries_file));
		currencyService.submit(new AssetsReader(context, R.raw.currrencies_file));
		countryExtraService.submit(new AssetsReader(context, R.raw.countries_extras));
		loadCountries();
	}

	/**
	 * Read all coutries_file from file
	 */
	private void loadCountries() {
		try {
			loadCurrencies();
			loadCountryExtras();
			final String values = countryService.take().get();
			Gson         gson   = new Gson();
			countries = gson.fromJson(values, Country[].class);
			addOtherCountryProperties();
			//Toast.makeText(context, "Init finished with " + countries.length + " countries loaded", Toast
			// .LENGTH_SHORT).show();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load the currencies from com.blongho.country_data.currencies.json
	 */
	private void loadCurrencies() throws InterruptedException, ExecutionException {
		final String currencyArray = currencyService.take().get();
		Gson         gson          = new Gson();
		Currency[]   currencies    = gson.fromJson(currencyArray, Currency[].class);
		for (final Currency currency : currencies) {
			currencyMap.put(currency.getCountry().toLowerCase(), currency);
		}
	}

	/**
	 * Load the extra information about a country
	 */
	private void loadCountryExtras() throws InterruptedException, ExecutionException {
		final String    country_extra = countryExtraService.take().get();
		Gson            gson          = new Gson();
		CountryExtras[] countryExtras = gson.fromJson(country_extra, CountryExtras[].class);
		for (CountryExtras extra : countryExtras) {
			countryExtrasMap.put(extra.getAlpha2().toLowerCase(), extra);
		}
	}

	/**
	 * Load the coutries_file and their flags in a Map container
	 * <br>
	 * Each country is flag is mapped with the country alpha2 and alpha3 codes
	 */
	private void addOtherCountryProperties() {
		for (final Country country : countries) {
			final String resource = "drawable/" + country.getAlpha2().toLowerCase();

			final int countryFlag = country.getAlpha2().equalsIgnoreCase("do") ? R.drawable.dominican :
			  context.getResources().getIdentifier(resource, null, context.getPackageName());

			country.setFlagResource(countryFlag);
			country.setCurrency(currencyMap.get(country.getAlpha2().toLowerCase()));
			country.setExtras(countryExtrasMap.get(country.getAlpha2().toLowerCase()));
			addFlag(country, countryFlag);
			countryAndFlag.add(country);

		}
		flagMap.put("globe", R.drawable.globe);
	}

	/**
	 * Add another country flag to the list of flags
	 *
	 * @param country The country for which the flag is to be added
	 * @param imageResource the image resource <br> This should be a drawable resource
	 */
	private static void addFlag(@NonNull final Country country, @DrawableRes @NonNull final Integer imageResource) {
		flagMap.put(country.getAlpha2().toLowerCase(), imageResource);
		flagMap.put(country.getName().toLowerCase(), imageResource);
		flagMap.put(country.getId(), imageResource);
		flagMap.put(country.getAlpha3().toLowerCase(), imageResource);
	}

	/**
	 * Get an instance of this class<br> This is a thread-safe singleton of the class. <br> Once called, all the flag
	 * resources are loaded and all coutries_file are assigned their flags. Calling this more than once has not
	 * benefit.
	 *
	 * @param ctx The application context (getApplicationContext())
	 *
	 * @return An instance of this class
	 */
	@AnyThread
	static WorldBuilder getInstance(Application ctx) {
		if (instance == null) {
			synchronized (WorldBuilder.class) {
				if (instance == null) {
					instance = new WorldBuilder(ctx);
				}
			}
		}
		return instance;
	}

	/**
	 * Return gibberish instead of null as a Country
	 *
	 * @return demo Country with name Earth
	 */
	static Country demoCountry() {
		Country demo = new Country("999", "Earth", "_e", "_ee");
		demo.setFlagResource(globe);
		demo.setCurrency(new Currency("_e", "Global currency", "BTC", "none"));
		demo.setExtras(new CountryExtras("_e", "equator", "0", "0", "globe"));
		return demo;
	}

	/**
	 * Get the coutries_file with their flags loaded
	 *
	 * @return An unmodifiable uArrayList with all coutries_file and their flags or empty list
	 */
	@AnyThread
	static List<Country> allCountriesAndFlags() {
		return instance != null && !countryAndFlag.isEmpty() ? Collections.unmodifiableList(countryAndFlag) :
		  Collections.<Country>emptyList();
	}

	/**
	 * Get the map with flags and their country attributes
	 *
	 * @return an unmodifiable Map<countryIdentifier, mapID> <br> or an empty map if the getInstance() has not been
	 *   called  or if the flagMap is empty
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
		return Collections.unmodifiableList(new ArrayList<>(currencyMap.values()));
	}

}
