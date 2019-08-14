/*
 * MIT License
 *
 * Copyright (c) 2019 Bernard Che Longho
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
 */

package com.blongho.country_data;

/**
 * CountryBase
 * <p>Base class for the Country. It holds the essentials of a country </p>
 */
class CountryBase {
	private final String id;        // The country's ISO 3166-1 numeric id
	private final String name;        // The official name of the country
	private final String alpha2;    // The country's ISO 3166 alpha2 id
	private final String alpha3;    // The country's ISO 3166 alpha3 id

	/**
	 * Create a country with the name, iso alpha2, alpha3 and flag
	 *
	 * @param id The numeric code of the country
	 * @param name The name of the country
	 * @param alpha2 The country's ISO 3166 alpha2 id
	 * @param alpha3 The country's ISO 3166 alpha3 id
	 */
	CountryBase(
	  final String id, final String name, final String alpha2, final String alpha3) {
		this.id = id;
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CountryBase{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", alpha2='").append(alpha2).append('\'');
		sb.append(", alpha3='").append(alpha3).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
