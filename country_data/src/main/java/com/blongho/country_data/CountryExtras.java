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

class CountryExtras {
	private final String alpha2;
	private final String capital;
	private final String area;
	private final String population;
	private final String continent;

	CountryExtras(
	  final String alpha2, final String capital, final String area, final String population, final String continent) {
		this.alpha2 = alpha2;
		this.capital = capital;
		this.area = area;
		this.population = population;
		this.continent = continent;
	}

	String getCapital() {
		return capital;
	}

	String getContinent() {
		return continent;
	}

	String getAlpha2() {
		return alpha2;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CountryInfo{");
		sb.append("capital='").append(capital).append('\'');
		sb.append(", area='").append(getArea()).append('\'');
		sb.append(", population='").append(getPopulation()).append('\'');
		sb.append(", continent='").append(continent).append('\'');
		sb.append('}');
		return sb.toString();
	}

	long getArea() {
		final String removeDecimal = area.substring(0, area.indexOf("."));
		return Long.parseLong(removeDecimal.replace(",", ""));
	}

	long getPopulation() {
		return Long.parseLong(population.replace(",", ""));
	}
}
