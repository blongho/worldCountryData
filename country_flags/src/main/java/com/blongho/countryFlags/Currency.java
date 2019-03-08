package com.blongho.countryFlags;

class Currency {
	private final String country;   //The alpha2 value of the country
	private final String name;//The full name of the currency
	private final String code;//The currency code
	private final String symbol;//The currency Symbol

	/**
	 * Create a currency without the symbol
	 */
	Currency(String countryCode, String currencyName, String currencyCode) {
		this(countryCode, currencyName, currencyCode, null);
	}

	/**
	 * @param countryCode  The alpha2 value of the country
	 * @param currencyName The full name of the currency
	 * @param currencyCode The currency code
	 * @param symbol       The currency Symbol
	 */
	Currency(
	  String countryCode, String currencyName, String currencyCode,
	  String symbol) {
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