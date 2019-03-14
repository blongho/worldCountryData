package com.blongho.country_data;

public final class Currency {
	private final String country;   //The alpha2 value of the country
	private final String name;//The full name of the currency
	private final String code;//The currency code
	private final String symbol;//The currency Symbol

	/**
	 * @param countryCode  The alpha2 value of the country
	 * @param currencyName The full name of the currency
	 * @param currencyCode The currency code
	 * @param symbol       The currency Symbol
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Currency [country=");
		builder.append(country);
		builder.append(", name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(code);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append("]");
		return builder.toString();
	}

}