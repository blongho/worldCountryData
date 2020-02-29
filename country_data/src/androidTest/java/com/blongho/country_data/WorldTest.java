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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WorldTest {

  private static final String TAG = "WorldTest";

  @BeforeClass
  public static void init() {
    World.init(InstrumentationRegistry.getInstrumentation().getContext());
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
    assertFalse(countries.isEmpty());
    assertNotNull(countries.get(0));
    log("Country list size= " + countries.size());
  }

  @Test
  public void getAllCurrencies() {
    final List<Currency> currencies = World.getAllCurrencies();
    assertFalse(currencies.isEmpty());
    assertNotNull(currencies.get(0));
    log("Currency list size= " + currencies.size());
  }

  private static void log(final String message) {
    Log.i(TAG, "display: --> " + message);

  }
}