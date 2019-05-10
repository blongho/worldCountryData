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
