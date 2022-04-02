/*
 * MIT License
 *
 * Copyright (c) 2019 - 2021 Bernard Longho
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

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/**
 * The currency of a {@link Country}
 * <p>
 * A {@link Currency} can not be instantiated but only obtained from a
 * {@link Country}
 * </p>
 *
 * @author Bernard Che Longho (blongho)
 * @since 2019-11-15
 */
public class Currency implements Parcelable {

  private final String country; // The alpha2 value of the country
  private final String name;// The full name of the currency
  private final String code;// The currency code
  private final String symbol;// The currency Symbol

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

  protected Currency(Parcel in) {
    country = in.readString();
    name = in.readString();
    code = in.readString();
    symbol = in.readString();
  }

  public static final Creator<Currency> CREATOR = new Creator<Currency>() {
    @Override
    public Currency createFromParcel(Parcel in) {
      return new Currency(in);
    }

    @Override
    public Currency[] newArray(int size) {
      return new Currency[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeString(country);
    parcel.writeString(name);
    parcel.writeString(code);
    parcel.writeString(symbol);
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
    if (this == o) {
      return true;
    }
    if (!(o instanceof Currency)) {
      return false;
    }

    final Currency currency = (Currency) o;

    if (country != null ? !country.equals(currency.country) : currency.country != null) {
      return false;
    }
    if (name != null ? !name.equals(currency.name) : currency.name != null) {
      return false;
    }
    if (code != null ? !code.equals(currency.code) : currency.code != null) {
      return false;
    }
    return symbol != null ? symbol.equals(currency.symbol) : currency.symbol == null;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  @NonNull
  public String toString() {
    return "Currency [country="
        + country
        + ", name="
        + name
        + ", code="
        + code
        + ", symbol="
        + symbol
        + "]";
  }
}