package com.blongho.countryFlags.utils;

import android.content.Context;

import com.blongho.countryFlags.Objects.Country;
import com.blongho.countryFlags.R;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class CountryFlagUtility {
	private static final int globeFlag = R.drawable.globe;
	private static final Country earth = Country.from("Earth", "xx", "xxx", globeFlag, 9999);
	private final static String empty = "globe";
	private static List<Country> allCountries = null;
	private static Map<String, Integer> flagMap = null;

	public static void init(final Context ctx) {
		CountryFlag.getInstance(ctx);
		allCountries = CountryFlag.allCountriesAndFlags();
		flagMap = CountryFlag.getFlagMap();
	}

	/**
	 * Get the flag of a country using the numeric code of the country
	 *
	 * @param countryCode The numeric code of the country
	 *
	 * @return An image resource representing the country flag or the image of the globe
	 */
	public static int getFlagOf(final int countryCode) {
		return getFlagOf(String.valueOf(countryCode));
	}

	/**
	 * Get the flag of a country
	 *
	 * @param countryIdentifier the 2  or 3 letter representation of the country {se|SE|SWE|swe} are all valid entries
	 *                          for a Swedish flag
	 *
	 * @return the id of the flag resource or -1 if the iso alpha2 or iso alpha3 is not correct if there is no entry in
	 * 	the flag container with that identify.
	 * 	<p>
	 * 	Note: If the values are correct and you still do not get the flag, create an issue and this will be resolved as
	 * 	soon as possible.
	 */
	public static int getFlagOf(final String countryIdentifier) {
		if (countryIdentifier.isEmpty()) {
			return flagMap.get(empty);
		}
		final Integer flag = flagMap.get(countryIdentifier.toLowerCase());
		return flag != null ? flag : flagMap.get(empty);
	}

	/**
	 * Get a country from any of its identifiers
	 *
	 * @param countryIdentifier The country name, alpha2 or alpha3 values, case insensitive
	 *
	 * @return A country a country with any of the attributes or a Earth
	 */
	public static Country getCountryFrom(final String countryIdentifier) {
		for (final Country c : allCountries) {
			if (c.getName().equalsIgnoreCase(countryIdentifier) || c.getAlpha2()
																	.equalsIgnoreCase(countryIdentifier) || c
					.getAlpha3().equalsIgnoreCase(countryIdentifier)) return c;
		}
		return earth;
	}

	/**
	 * Get a country from its numeric code
	 *
	 * @param numericCode The country's numeric code
	 *
	 * @return A country a country with any of the attributes or a Earth
	 */
	public static Country getCountryFrom(final int numericCode) {
		for (final Country c : allCountries) {
			if (c.getId() == numericCode) {
				return c;
			}
		}
		return earth;
	}

	/**
	 * Get an immutable list of all the countries with their flags
	 *
	 * @return List of all the countries. <br> Attempting to modify this list invokes an exception and your app will
	 * 	crash.
	 */
	public static List<Country> getAllCountries() {
		return Collections.unmodifiableList(allCountries);
	}
}
