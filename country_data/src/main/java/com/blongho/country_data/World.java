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

import android.content.Context;
import com.blongho.country_data.exception.CountryDataException;
import java.util.List;

/**
 * The World knows all the countries and their name, alpha2, alpha3, numeric code and flag. <br> If
 * a country does not exist or is at least not formally recognized, that country will be <br>
 * represented as Earth with flag that of the globe
 *
 * @since 2019-11-15
 * <b>Note: <i>The data contained here is valid as of 2019-11-16 02:27 from
 * https://www.geonames.org/countries/</i></b>
 */
public final class World {

  private static WorldBuilder instance = null;

  /**
   * Initialize the world, just as it is today with all its countries and flags
   *
   * @param ctx The context where this object is called (getAppicationContext)
   */
  public static void init(final Context ctx) {
    instance = WorldBuilder.getInstance(ctx);
  }

  /**
   * Get the flag of a country using the numeric code of the country
   *
   * @param countryCode The numeric code of the country
   * @return An image resource representing the country flag or the image of the globe
   */
  public static int getFlagOf(final int countryCode) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return getFlagOf(String.valueOf(countryCode));
  }

  /**
   * Get the flag of a country
   *
   * @param countryIdentifier the 2  or 3 letter representation of the country
   * <br> e.g {se|SE|SWE|swe} are all valid entries
   * for a Swedish flag
   * @return the id of the flag resource or id of globe image if the <br> iso alpha2 or iso alpha3
   * is not correct or if  there is no <br> entry in the flag container with that identify.
   * <p>
   * Note: If the values are correct and you still do not get the flag, create an issue and this
   * will be resolved as soon as possible.
   */
  public static int getFlagOf(final String countryIdentifier) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    if (countryIdentifier.isEmpty()) {
      return getWorldFlag();
    }
    return WorldBuilder.flagFromCountry(countryIdentifier);
  }

  /**
   * Get the image of the globe directly rather than querying World.getFlagOf("globe")
   *
   * @return The image of the globe as we know it today
   */
  public static int getWorldFlag() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldBuilder.globe();
  }

  /**
   * Get a country from its numeric code
   *
   * @param numericCode The country's numeric code
   * @return A country a country with any of the attributes or a Earth
   */
  public static Country getCountryFrom(final int numericCode) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return getCountryFrom(String.valueOf(numericCode));
  }

  /**
   * Get a country from any of its identifiers
   *
   * @param countryIdentifier The country name, alpha2 or alpha3 values, case insensitive
   * @return A country a country with any of the attributes or a Earth
   */
  public static Country getCountryFrom(final String countryIdentifier) {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldBuilder.countryFrom(countryIdentifier);
  }

  /**
   * Get an immutable list of all the countries with their flags
   *
   * @return List of all the countries. <br> Attempting to modify this list invokes an
   * com.blongho.country_data.exception and your app will crash.
   */
  public static List<Country> getAllCountries() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldBuilder.countries();
  }

  /**
   * Return all the currencies of the world
   *
   * @return The currencies of the world {alpha2, curencyName, currencyCode, currencySymbol}
   */
  public static List<Currency> getAllCurrencies() {
    if (instance == null) {
      throw new CountryDataException(
          "You have to call World.init(getApplicationContext()) before this method.");
    }
    return WorldBuilder.currencies();
  }
}
