package com.blongho.country_flags.Objects;

import androidx.annotation.DrawableRes;

/**
 * @author Bernard Che Longho (blongho) This class is built inorder to extract the files located at <br>
 * @file Country.java
 * @brief A country is represented by the name, the 2 letter representation, the 3 letter representation
 * @see https://raw.githubusercontent.com/stefangabos/world_countries/master/data/en/countries.json A sample output of the
 * 	file is
 **/

public class Country {
	private String name;
	private String alpha2;
	private String alpha3;
	@DrawableRes
	private int flagResource;

	public Country(final String name, final String alpha2, final String alpha3, final int flagResource) {
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.flagResource = flagResource;
	}

	public Country(final String name, final int flagResource) {
		this.name = name;
		this.flagResource = flagResource;
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

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Country)) return false;

		final Country country = (Country) o;

		if (flagResource != country.flagResource) return false;
		if (name != null ? !name.equals(country.name) : country.name != null) return false;
		if (alpha2 != null ? !alpha2.equals(country.alpha2) : country.alpha2 != null) return false;
		return alpha3 != null ? alpha3.equals(country.alpha3) : country.alpha3 == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (alpha2 != null ? alpha2.hashCode() : 0);
		result = 31 * result + (alpha3 != null ? alpha3.hashCode() : 0);
		result = 31 * result + flagResource;
		return result;
	}

	@Override
	public String toString() {
		return "Country{" + "name='" + name + '\'' + ", alpha2='" + alpha2 + '\'' + ", alpha3='" + alpha3 + '\'' + ", " +
			   "flagResource=" + flagResource + '}';
	}
}