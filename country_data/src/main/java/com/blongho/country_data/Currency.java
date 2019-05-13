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
 * A currency object maps to Country using the alpha2 of the country.<br>
 *
 * @author Bernard Che Longho (blongho02@gmail.com)
 * @since March 2019
 *
 *   <br> <br>
 *   A currency object. <br>The currency has the alpha2 of the country, the currency name, its code and symbol.<br> The
 *   alpha2 of the country can be used to set the currency to the right country
 */
public final class Currency {
	private final String country;   //The alpha2 value of the country
	private final String name;//The full name of the currency
	private final String code;//The currency code
	private final String symbol;//The currency Symbol

	/**
	 * @param countryCode The alpha2 value of the country
	 * @param currencyName The full name of the currency
	 * @param currencyCode The currency code
	 * @param symbol The currency Symbol
	 */
	Currency(
	  String countryCode, String currencyName, String currencyCode, String symbol) {
		super();
		this.country = countryCode;
		this.name = currencyName;
		this.code = currencyCode;
		this.symbol = symbol;
	}

	/**
	 * Get the country alpha2 code where this currency is used
	 *
	 * @return the country
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * The name of the currency
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * The currency code
	 *
	 * @return the code
	 */
	public final String getCode() {
		return code;
	}

	/**
	 * The symbol of the currency
	 *
	 * @return the symbol
	 */
	public final String getSymbol() {
		return symbol;
	}

	@Override
	public int hashCode() {
		int result = country != null ? country.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Currency)) return false;

		final Currency currency = (Currency) o;

		if (country != null ? !country.equals(currency.country) : currency.country != null) return false;
		if (name != null ? !name.equals(currency.name) : currency.name != null) return false;
		if (code != null ? !code.equals(currency.code) : currency.code != null) return false;
		return symbol != null ? symbol.equals(currency.symbol) : currency.symbol == null;
	}

	/**
	 * The string representation of the currency
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Currency [");
		builder.append("name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(code);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append("]");
		return builder.toString();
	}
}