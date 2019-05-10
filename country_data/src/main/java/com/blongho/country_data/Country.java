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

import android.support.annotation.AnyThread;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;

/**
 * A country is represented by the name, the 2 letter representation, the 3 letter representation. It is non-mutable
 * <p>The user should not be able to create a new Country as in real life,   countries are not just created. </p>
 *
 * @author Bernard Che Longho (blongho02@gmail.com)
 * @since 2019 -05-10
 */
@AnyThread
public final class Country {

	private static String UNKNOWN = "UNKNOWN";
	private final String id;        // The country's ISO 3166-1 numeric id
	private final String name;        // The official name of the country
	private final String alpha2;    // The country's ISO 3166 alpha2 id
	private final String alpha3;    // The country's ISO 3166 alpha3 id
	@DrawableRes
	private final int flagResource; // The image resource that represent the
	private final Currency currency; // The currency for this country
	private final CountryExtras extras;

	/**
	 * Create a country with the name, iso alpha2, alpha3 and flag
	 *
	 * @param id           The numeric code of the country
	 * @param name         The name of the country
	 * @param alpha2       The country's ISO 3166 alpha2 id
	 * @param alpha3       The country's ISO 3166 alpha3 id
	 * @param flagResource The fag resource
	 * @param currency     The currency for this country
	 */
	@Deprecated
	private Country(
	  final String id, final String name, final String alpha2, final String alpha3, final int flagResource,
	  @Nullable final Currency currency) {
		this.id = id;
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.flagResource = flagResource;
		this.currency = currency;
		extras = null;
	}

	private Country(
	  final String id, final String name, final String alpha2, final String alpha3, final int flagResource,
	  @Nullable final Currency currency, final CountryExtras extras) {
		this.id = id;
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.flagResource = flagResource;
		this.currency = currency;
		this.extras = extras;
	}

	/**
	 * Create an immutable Country object from attributes given
	 *
	 * @param name         The country nae
	 * @param alpha2       The alpha2 characters of the country
	 * @param alpha3       The alpha3 characters of the country
	 * @param flagResource The image resource pointing to the country map
	 * @param id           The numeric iso code of the country
	 * @param currency     the currency
	 *
	 * @return a Country with all its parameters
	 */
	@Deprecated
	static Country from(
	  final String name, final String alpha2, final String alpha3, final int flagResource, final String id,
	  @Nullable final Currency currency) {
		return new Country(id, name, alpha2, alpha3, flagResource, currency);
	}

	/**
	 * Create an immutable Country object from attributes given
	 *
	 * @param name         The country nae
	 * @param alpha2       The alpha2 characters of the country
	 * @param alpha3       The alpha3 characters of the country
	 * @param flagResource The image resource pointing to the country map
	 * @param id           The numeric iso code of the country
	 * @param currency     the currency
	 * @param extras       Extra information about the country[area, population, continent, capital]
	 *
	 * @return a Country with all its parameters
	 */
	static Country from(
	  final String name, final String alpha2, final String alpha3, final int flagResource, final String id,
	  @Nullable final Currency currency, CountryExtras extras) {
		return new Country(id, name, alpha2, alpha3, flagResource, currency, extras);
	}

	/**
	 * Get the name of the country
	 *
	 * @return The country name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Get the alpha2 of the country
	 *
	 * @return The ISO 3166 alpha2 id of the country
	 */
	public final String getAlpha2() {
		return alpha2;
	}

	/**
	 * Get the alpha3 of the country
	 *
	 * @return The ISO 3166 alpha3 id of the country
	 */
	public final String getAlpha3() {
		return alpha3;
	}

	/**
	 * Get the image resouce of the country
	 *
	 * @return The R.drawable.id representing the flag of the country
	 */
	public final int getFlagResource() {
		return flagResource;
	}

	/**
	 * Get the ISO 3166-1 numeric code of the country
	 *
	 * @return The ISO 3166-1 numeric code of the country
	 */
	public final String getId() {
		return id;
	}

	/**
	 * Determine if an identifier is part of a country
	 *
	 * @param identifier The identifier {id|alpha2|alpha3|name}
	 *
	 * @return True if the identifier is part of this Country
	 */
	final boolean hasIdentifier(final String identifier) {
		return name.equalsIgnoreCase(identifier) || alpha2.equalsIgnoreCase(identifier) || alpha3
		  .equalsIgnoreCase(identifier) || id.equalsIgnoreCase(identifier);
	}

	/**
	 * Get the currency for this country
	 *
	 * @return The country currency
	 */
	public com.blongho.country_data.Currency getCurrency() {
		return currency;
	}

	/**
	 * Get capital
	 *
	 * @return the capital city of the country or "UNKNOWN" if the value is not available
	 */
	public final String getCapital() {
		return extras != null ? extras.getCapital() : UNKNOWN;
	}

	/**
	 * Get continent
	 *
	 * @return the continent where this country is located or "UNKNOWN" if for some reason, the extra information is
	 * not
	 *   available
	 */
	public final String getContinent() {
		return extras != null ? Continents.continentMap.get(extras.getContinent().toUpperCase()) : UNKNOWN;
	}

	/**
	 * Get the surface area of this country (km^2)
	 *
	 * @return the surface area of this country in kilometers squared or 0 if the value is not known
	 */
	public final long getArea() {
		return extras != null ? extras.getArea() : 0;
	}

	/**
	 * Get population
	 *
	 * @return the population of this country or O if the value is not none
	 */
	public final long getPopulation() {
		return extras != null ? extras.getPopulation() : 0;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Country{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", alpha2='").append(alpha2).append('\'');
		sb.append(", alpha3='").append(alpha3).append('\'');
		sb.append(", flagResource=").append(flagResource);
		sb.append(", currency=").append(currency);
		sb.append(", extras=").append(extras);
		sb.append('}');
		return sb.toString();
	}
}