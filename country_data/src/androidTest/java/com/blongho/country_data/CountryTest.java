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

import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CountryTest {

  private static Country sweden;

  @BeforeClass
  public static void setUp() {
    World.init(InstrumentationRegistry.getInstrumentation().getContext());
    sweden = World.getCountryFrom("se");
  }

  @Test
  public void getId() {
    assertEquals(sweden.getId(), 752);
  }

  @Test
  public void getCapital() {
    assertEquals(sweden.getCapital().toLowerCase(), "stockholm");
  }

  @Test
  public void getContinent() {
    assertEquals(sweden.getContinent().toLowerCase(), "europe");
  }

  @Test
  public void getArea() {
  }

  @Test
  public void getPopulation() {
  }

  @Test
  public void getName() {
    assertEquals(sweden.getName().toLowerCase(), "sweden");
  }

  @Test
  public void getAlpha2() {
    assertEquals(sweden.getAlpha2().toLowerCase(), "se");
  }

  @Test
  public void getAlpha3() {
    assertEquals(sweden.getAlpha3().toLowerCase(), "swe");
  }
}