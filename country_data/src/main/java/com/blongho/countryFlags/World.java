package com.blongho.countryFlags;

import android.content.Context;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The World knows all the countries and their name, alpha2, alpha3, numeric
 * code and flag. <br> If a country does not exist or is at least not formally
 * recognized, that country will be <br> represented as Earth with flag that of
 * the globe
 */
public final class World {
	private static final int globeFlag = R.drawable.globe;
	private static final Country earth = Country
	  .from("Earth", "xx", "xxx", globeFlag, "9999", null);
	private final static String empty = "globe";
	private static List<Country> allCountries = null;
	private static Map<String, Integer> flagMap = null;
	private static WorldBuilder instance = null;

	/**
	 * Initialize the world, just as it is today with all its countries and
	 * flags
	 *
	 * @param ctx The context where this object is called
	 *               (getAppicationContext)
	 */
	public static void init(final Context ctx) {
		instance = WorldBuilder.getInstance(ctx);
		allCountries = WorldBuilder.allCountriesAndFlags();
		flagMap = WorldBuilder.getFlagMap();
	}

	/**
	 * Get the flag of a country using the numeric code of the country
	 *
	 * @param countryCode The numeric code of the country
	 *
	 * @return An image resource representing the country flag or the image of
	 *   the globe
	 */
	public static int getFlagOf(final int countryCode) {
		if (instance == null) {
			throw new UnsupportedOperationException(
			  "You have to call World.init(getApplicationContext) before " +
			  "calling this method");
		}
		return getFlagOf(String.valueOf(countryCode));
	}

	/**
	 * Get the flag of a country
	 *
	 * @param countryIdentifier the 2  or 3 letter representation of the
	 *                          country
	 *                          <br> e.g {se|SE|SWE|swe} are all valid entries
	 *                          for a Swedish flag
	 *
	 * @return the id of the flag resource or id of globe image if the <br> iso
	 *   alpha2 or iso alpha3 is not correct or if  there is no <br> entry in
	 *   the flag container with that identify.
	 *   <p>
	 *   Note: If the values are correct and you still do not get the flag,
	 *   create an issue and this will be resolved as soon as possible.
	 */
	public static int getFlagOf(@NotNull final String countryIdentifier) {
		if (countryIdentifier.isEmpty()) {
			return flagMap.get(empty);
		}
		final Integer flag = flagMap.get(countryIdentifier.toLowerCase());
		return flag != null ? flag : flagMap.get(empty);
	}

	/**
	 * Get a country from its numeric code
	 *
	 * @param numericCode The country's numeric code
	 *
	 * @return A country a country with any of the attributes or a Earth
	 */
	public static Country getCountryFrom(final int numericCode) {
		return getCountryFrom(String.valueOf(numericCode));
	}

	/**
	 * Get a country from any of its identifiers
	 *
	 * @param countryIdentifier The country name, alpha2 or alpha3 values, case
	 *                          insensitive
	 *
	 * @return A country a country with any of the attributes or a Earth
	 */
	public static Country getCountryFrom(final String countryIdentifier) {
		for (final Country c : allCountries) {
			if (c.hasIdentifier(countryIdentifier)) return c;
		}
		return earth;
	}

	/**
	 * Get an immutable list of all the countries with their flags
	 *
	 * @return List of all the countries. <br> Attempting to modify this list
	 *   invokes an exception and your app will crash.
	 */
	public static List<Country> getAllCountries() {
		return Collections.unmodifiableList(allCountries);
	}

	/**
	 * Return all the currencies of the world
	 * @return The currencies of the world {alpha2, curencyName, currencyCode, currencySymbol}
	 */
	public static List<Currency> getAllCurrencies(){
		return WorldBuilder.currencyList();
	}
}
