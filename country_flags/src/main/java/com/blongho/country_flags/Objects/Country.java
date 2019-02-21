package com.blongho.country_flags.Objects;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Bernard Che Longho (blongho) This class is built inorder to extract the files located at <br>
 * @file Country.java
 * @brief A country is represented by the name, the 2 letter representation, the 3 letter representation and the
 * 	currency
 * @see https://raw.githubusercontent.com/stefangabos/world_countries/master/data/en/world.json A sample output of the
 * 	file is
 **/

public class Country {
	private String name;
	private String alpha2;
	private String alpha3;
	@DrawableRes
	private int flagResource;
	private Currency currency;

	/**
	 * A constructor to create a country with just a name.
	 *
	 * @param name the name of the country
	 */
	public Country(@NonNull final String name) {
		this.name = name;
	}

	/**
	 * Create a country with name and flag
	 *
	 * @param name         the name of the country
	 * @param flagResource the id of the flag
	 */
	public Country(@Nullable final String name, final int flagResource) {
		this.name = name;
		this.flagResource = flagResource;
	}

	/**
	 * Create a country with the name, flag resource and the currency
	 *
	 * @param name         The name of the country
	 * @param flagResource the id of the flag
	 * @param currency     the currency of the country
	 */
	public Country(final String name, final int flagResource, final Currency currency) {
		this.name = name;
		this.flagResource = flagResource;
		this.currency = currency;
	}

	/**
	 * Create a country with all its attributes
	 *
	 * @param name         the name of the country
	 * @param alpha2       the two letter representation of the country
	 * @param alpha3       the three letter representation of the country
	 * @param flagResource the id of the flag of the country
	 * @param currency     the currency of the country
	 */
	public Country(
		@NonNull final String name, @Nullable final String alpha2, @Nullable final String alpha3,
		@Nullable final int flagResource, @Nullable final Currency currency) {
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.flagResource = flagResource;
		this.currency = currency;
	}

	/**
	 * Create a country with the name, the two letter and three letter representations
	 * @param name the name of the country
	 * @param alpha2 the two letter representation of the country
	 * @param alpha3 the three letter representation of the country
	 */
	public Country(final String name, final String alpha2, final String alpha3) {
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(final String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(final String alpha3) {
		this.alpha3 = alpha3;
	}

	public int getFlagResource() {
		return flagResource;
	}

	public void setFlagResource(final int flagResource) {
		this.flagResource = flagResource;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(final Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Country{" + "name='" + name + '\'' + ", alpha2='" + alpha2 + '\'' + ", alpha3='" + alpha3 + '\'' + ", " +
			   "flagResource=" + flagResource + ", currency=" + currency + '}';
	}
}