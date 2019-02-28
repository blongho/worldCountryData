package com.blongho.countryFlags.Objects;

import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

/**
 * @author Bernard Che Longho (blongho) This class is built inorder to extract the files located at <br>
 * @file Country.java
 * @brief A country is represented by the name, the 2 letter representation, the 3 letter representation
 * @see https://raw.githubusercontent.com/stefangabos/world_countries/master/data/en/countries.json A sample output of
 * 	the file is
 **/

@AnyThread
public final class Country {
	private final Integer id;        // The country's ISO 3166-1 numberic id
	private final String name;        // The official name of the country
	private final String alpha2;    // The country's ISO 3166 alpha2 id
	private final String alpha3;    // The country's ISO 3166 alpha3 id
	@DrawableRes
	private final int flagResource; // The image resource that represent the country flag

	/**
	 * Create a country with the name, iso alpha2, alpha3 and flag
	 *
	 * @param name         The name of the country
	 * @param alpha2       The country's ISO 3166 alpha2 id
	 * @param alpha3       The country's ISO 3166 alpha3 id
	 * @param flagResource The fag resource
	 */
	private Country(
		final String name, final String alpha2, final String alpha3, final int flagResource,
		@Nullable final Integer id) {
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.flagResource = flagResource;
		this.id = id;
	}

	public static Country from(final String name, final String alpha2, final String alpha3, final int flagResource,
							   final int id){
		return new Country(name, alpha2, alpha3, flagResource, id);
	}

	public String getName() {
		return name;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public int getFlagResource() {
		return flagResource;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (alpha2 != null ? alpha2.hashCode() : 0);
		result = 31 * result + (alpha3 != null ? alpha3.hashCode() : 0);
		result = 31 * result + flagResource;
		return result;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Country)) return false;

		final Country country = (Country) o;

		if (flagResource != country.flagResource) return false;
		if (id != null ? !id.equals(country.id) : country.id != null) return false;
		if (name != null ? !name.equals(country.name) : country.name != null) return false;
		if (alpha2 != null ? !alpha2.equals(country.alpha2) : country.alpha2 != null) return false;
		return alpha3 != null ? alpha3.equals(country.alpha3) : country.alpha3 == null;
	}

	@Override
	public String toString() {
		return "Country{" + "id=" + id + ", name='" + name + '\'' + ", alpha2='" + alpha2 + '\'' + ", alpha3='"
			   + alpha3 + '\'' + ", flagResource=" + flagResource + '}';
	}


}