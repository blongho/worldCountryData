package com.blongho.country_data;

import java.util.HashMap;
import java.util.Map;

class Continents {
	final static Map<String, String> continentMap = new HashMap<String, String>() {{
		put("AF", "Africa");
		put("EU", "Europe");
		put("SA", "South America");
		put("NA", "North America");
		put("OC", "Oceania");
		put("AS", "Asia");
		put("AN", "Antarctica");
	}};
}
