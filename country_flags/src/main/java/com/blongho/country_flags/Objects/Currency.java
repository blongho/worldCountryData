
/**
 * @file 	: Currency.java
 * @author 	: Bernard Che Longho (blongho)
 * @since 	: 2019-02-19
 * @brief	: A Currency object. <br>
 * 			  A currency is represented by the symbol and the full name. This shall be used in Country
 */
package com.blongho.country_flags.Objects;

public class Currency {
	private String symbol;
	private String name;

	public Currency() {
		symbol = "";
		name = "";
	}

	/**
	 * The Constructor
	 * @param symbol The symbol of the currency
	 * @param name The full name of the currency
	 */
	public Currency(final String symbol, final String name) {
		this.symbol = symbol;
		this.name = name;
	}

	/**
	 * A currency with just the symbol. In such a case, the name is empty
	 * @param symbol the symbol of the currency
	 */
	public Currency(final String symbol) {
		this.symbol = symbol;
		this.name = "";
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Currency)) return false;

		final Currency currency = (Currency) o;

		if (!symbol.equalsIgnoreCase(currency.symbol)) return false;
		return name != null ? name.equalsIgnoreCase(currency.name) : currency.name == null;
	}

	@Override
	public int hashCode() {
		int result = symbol.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Currency{" + "symbol='" + symbol + '\'' + ", name='" + name + '\'' + '}';
	}
}
