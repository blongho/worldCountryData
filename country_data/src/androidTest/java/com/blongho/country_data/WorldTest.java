/*
 * MIT License
 *
 * Copyright (c) 2019 - 2022 Bernard Longho
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.blongho.country_data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import com.blongho.country_data.World.Continent;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WorldTest {

  private static final String TAG = "WorldTest";
  final private static List<String> COUNTRY_NAMES = Arrays.asList(
      "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla",
      "Albania", "Armenia", "Angola", "Antarctica", "Argentina", "American Samoa", "Austria",
      "Australia", "Aruba", "Åland", "Azerbaijan", "Bosnia and Herzegovina", "Barbados",
      "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin",
      "Saint Barthélemy", "Bermuda", "Brunei", "Bolivia", "Bonaire, Sint Eustatius, and Saba",
      "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize", "Canada",
      "Cocos (Keeling) Islands", "DR Congo", "Central African Republic", "Congo Republic",
      "Switzerland", "Ivory Coast", "Cook Islands", "Chile", "Cameroon", "China", "Colombia",
      "Costa Rica", "Cuba", "Cabo Verde", "Curaçao", "Christmas Island", "Cyprus", "Czechia",
      "Germany", "Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador",
      "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland", "Fiji",
      "Falkland Islands", "Micronesia", "Faroe Islands", "France", "Gabon", "United Kingdom",
      "Grenada", "Georgia", "French Guiana", "Guernsey", "Ghana", "Gibraltar", "Greenland",
      "The Gambia", "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece",
      "South Georgia and South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana",
      "Hong Kong", "Heard and McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary",
      "Indonesia", "Ireland", "Israel", "Isle of Man", "India", "British Indian Ocean Territory",
      "Iraq", "Iran", "Iceland", "Italy", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya",
      "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros", "St Kitts and Nevis", "North Korea",
      "South Korea", "Kuwait", "Cayman Islands", "Kazakhstan", "Laos", "Lebanon", "Saint Lucia",
      "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg", "Latvia",
      "Libya", "Morocco", "Monaco", "Moldova", "Montenegro", "Saint Martin", "Madagascar",
      "Marshall Islands", "North Macedonia", "Mali", "Myanmar", "Mongolia", "Macao",
      "Northern Mariana Islands", "Martinique", "Mauritania", "Montserrat", "Malta", "Mauritius",
      "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "New Caledonia", "Niger",
      "Norfolk Island", "Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "Nauru", "Niue",
      "New Zealand", "Oman", "Panama", "Peru", "French Polynesia", "Papua New Guinea",
      "Philippines", "Pakistan", "Poland", "Saint Pierre and Miquelon", "Pitcairn Islands",
      "Puerto Rico", "Palestine", "Portugal", "Palau", "Paraguay", "Qatar", "Réunion", "Romania",
      "Serbia", "Russia", "Rwanda", "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan",
      "Sweden", "Singapore", "Saint Helena", "Slovenia", "Svalbard and Jan Mayen", "Slovakia",
      "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname", "South Sudan",
      "São Tomé and Príncipe", "El Salvador", "Sint Maarten", "Syria", "Eswatini",
      "Turks and Caicos Islands", "Chad", "French Southern Territories", "Togo", "Thailand",
      "Tajikistan", "Tokelau", "Timor-Leste", "Turkmenistan", "Tunisia", "Tonga", "Turkey",
      "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania", "Ukraine", "Uganda",
      "U.S. Outlying Islands", "United States", "Uruguay", "Uzbekistan", "Vatican City",
      "St Vincent and Grenadines", "Venezuela", "British Virgin Islands", "U.S. Virgin Islands",
      "Vietnam", "Vanuatu", "Wallis and Futuna", "Samoa", "Kosovo", "Yemen", "Mayotte",
      "South Africa", "Zambia", "Zimbabwe");
  private static Context context;

  @BeforeClass
  public static void setUp() {
    context = InstrumentationRegistry.getInstrumentation().getContext();
    World.init(context);
  }

  private static void log(final String message) {
    Log.i(TAG, message);

  }

  @Test
  public void allCountriesShouldExist() {
    boolean countryExits = true;
    final List<Country> countries = World.getAllCountries();
    for (Country c : countries) {
      if (c.getName().equalsIgnoreCase("indonesia")) {
        Log.i(TAG, "allCountriesShouldExist library: " + c);
      }
    }
    for (String s : COUNTRY_NAMES) {

      if (s.equalsIgnoreCase("indonesia")) {
        Log.i(TAG, "allCountriesShouldExist strings: " + s);
      }
    }
  }

  @Test
  public void getFlagOf() {
    final int flagFromISO2 = World.getFlagOf("se");
    final int flagFromISO3 = World.getFlagOf("swe");
    final int flagFromNumericCode = World.getFlagOf(752);
    Assert.assertTrue(flagFromISO2 != -1);
    Assert.assertTrue(flagFromISO3 != -1);
    Assert.assertTrue(flagFromNumericCode != -1);
    assertEquals(flagFromISO2, flagFromISO3);
    assertEquals(flagFromISO2, flagFromNumericCode);
    assertEquals(flagFromISO3, flagFromNumericCode);

    log("The flags from iso2 and iso3 are [" + flagFromISO2 + "==" + flagFromISO3 + "]");
    log("The flag from numeric code is same as from iso2 [" + flagFromISO2 + "=="
        + flagFromNumericCode + "]");
  }

  @Test
  public void getCountryFrom() {
    final Country sweden2 = World.getCountryFrom("se");
    final Country sweden3 = World.getCountryFrom("swe");
    final Country swedenNumeric = World.getCountryFrom(752);
    assertEquals(sweden2, sweden3);
    assertEquals(sweden2, swedenNumeric);

    log(sweden2.toString());
  }

  @Test
  public void getAllCountries() {
    final List<Country> countries = World.getAllCountries();
    assertFalse("The list of countries is not empty", countries.isEmpty());
    for (final Country country : countries) {
      assertNotNull("Country " + country.getName() + "'s currency is not null",
          country.getCurrency());
      assertNotNull("A country has a name", country.getName());
    }
    log("Country list size= " + countries.size());
  }

  @Test
  public void getAllCurrencies() {
    final List<Currency> currencies = World.getAllCurrencies();
    assertFalse("The list of currencies is not empty", currencies.isEmpty());
    for (final Currency currency : currencies) {
      final Country country = World.getCountryFrom(currency.getCountry());
      if (country != null) {
        assertNotNull(
            "The currency " + currency.getName() + " used by " + country.getName()
                + " has a symbol",
            currency.getSymbol());
        assertNotNull(
            "The currency " + currency.getName() + " used by " + country.getName() + " has code",
            currency.getCode());
        assertNotNull(
            "The currency " + currency.getName() + " used by " + country.getName() + " has name",
            currency.getName());
      }
    }
    log("Currency list size= " + currencies.size());
  }

  @Test
  public void allCountriesHaveFlags() {
    final List<Country> countries = World.getAllCountries();

    for (final Country country : countries) {
      log("allCountriesHaveFlags: country= " + country.getAlpha2() + " flag " + country
          .getFlagResource());
      assertTrue("There is a flag resource assigned to " + country.getName(),
          country.getFlagResource() > 0);
    }
  }

  @Test
  public void itIsPossibleToGetCountriesFromAContinent() {
    final Continent[] continents = Continent.values();
    for (final Continent value : continents) {
      final List<Country> countryList = World.getCountriesFrom(value);
      for (final Country country : countryList) {
        assertEquals(String.format("The country %s is in %s", country.getName(), value.getName()),
            country.getContinent(), value.getName());
        log(String.format("The country %s is in %s", country.getName(), value.getName()));

      }
    }

    List<Country> all = World.getCountriesFrom(null);
    assertEquals(
        "When null is passed as parameter to World.getCountriesFrom, we get all the countries",
        all.size(), World.getAllCountries().size());
  }

  @Test
  public void worldShouldContainAllCountries() {
    final List<Country> countries = World.getAllCountries();
    assertEquals(countries.size(), COUNTRY_NAMES.size());
    for (Country country : countries) {
      assertTrue(COUNTRY_NAMES.contains(country.getName()));
    }

  }


}