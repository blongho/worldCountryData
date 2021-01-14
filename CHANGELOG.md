# Change log on release notes
---
## v1.5.1 [Jan 14, 2021]
### Updates Country information and library code cleanup
- Country data accurate as of 2021-01-12 08:30 CET from [Geonames](https://www.geonames.org/countries/)
- Updates documentation of the readme as well as info on pro-guard
- Adds possibility to easily get countries from a continent 
- Clean up code to remove un-used and unnecessary classes
- Introduces filters such that only countries and currencies with all attributes are included. 
- Includes unite tests 

---
## v1.5 [Apr 5, 2020]
### Flag resources are now converted from .png to vector asserts
- The library is now smaller thanks to @eagskunst  for converting the flag resources to vector drawables. 
- Adds EU flag which can be used for EUROs currency
- Includes more instrumentation tests. 

__All method calls remain the same. Just change the version number__


---
## v1.4 [Feb 29, 2020]
### Bug fixes and updates documentation
- Updates library readme as well remove bug that caused some files not to be updated.
- Minor code refactoring
- Addition of unit tests
- Updates documentation

---
## v1.3 [Sep 29, 2019]
### Migrates library to AndroidX and changes package name
- This release migrates the codebase to AndroidX
- Package name change from world_coutry_data -> worldCountryData
- A demo app in the project repository

---
## v1.2.0 [Sep 29, 2019]
### Get more Country info - population, surface area, capital city...
Do you want to know the most populated country in the world or the smallest country of the world or you are planning on a vacation and you want to know the main city (capital city)?

In this release, you are now able to do the following

- get the country population
- get the capital city of the country
- get the surface area of the country
- get the continent of a country

==> Check the java documentation for more https://blongho.github.io/world-country-data/
Report any bugs by creating an issue

In the future release, it will be possible to get the cities (all major cities) of any country and more more...

---
## v1.1.0 [Mar 14, 2019]
### Get currency for each country
- Changed library package from countryFlags to country_data.
    The latter better conveys the information contained in the library.
    The former had only country flags as extra information apart from the
    country identifiers. This version and upcoming versions will have more
    information about a country.
- Cleaned code base and improve documentation

The current version have the currency for each country. Subsequent
versions will have more country data

--- 

## v1.1.0 [Mar 14, 2019]
### Get currency for each country
- In this version, it is now possible to get the list of currencies of the world
 ```java
  World.init(getApplicationContext()); // initialize data
  List<Currency> currencies = World.getAllCurrencies()
  // Currency [country=NZ, name=New Zealand Dollars, code=NZD, symbol=$]
```
  
  
- Changed library package from countryFlags to country_data.
    The latter better conveys the information contained in the library.
    The former had only country flags as extra information apart from the
    country identifiers. This version and upcoming versions will have more
    information about a country.
- Cleaned code base and improve documentation

The current version have the currency for each country. Subsequent
versions will have more country data

--- 
## v1.0 [Mar 5, 2019]
###  Get countries of the world, and their flags as well as country codes
his release is provides a more intuitive interface for the user.  <br>

Major changes include:
1. Removal of ability of user to create a country in their app.
 In real world, countries are not created like that.

2.To get a country, a user has to know any of the four identifiers of the country
 - The country name eg Sweden
 - The country numeric code eg 752
 - The alpha2 of the country eg "se"
- The alpha3 of the country eg "swe"

With these, Sweden can be created alongside its flag using
```java
World.init(getApplicationContext()); 
// you call this just once in your program. It wraps a singleton 
// that initializes everything that the library is to offer
Country sweden = World.getCountryFrom("sweden"|"se"|"swe"|752); 
```
3. To get the flag of a country, the user needs any of the identifiers mensioned in 2 above, then using two methods
```java
World.init(getApplicationContext());
final int swedishFlag = World.getFlagOf("sweden"|"se"|"swe"|752);
```
4. If you are interested in all the countries of the world 
```java
World.init(getApplicationContext());
final List<Country> countries = World.getAllCountries(); 
// This list cannot be modified by adding, sorting or removing an element. 
// You can only retrieve information therein
```¨
NB: All Country identifiers have getters so you can use that to retrieve a Country
from `List<Country> countries`
```
Give a star to the repository to get updates of new features. 

---
## v0.1.1 [Feb 29, 2020]
### Get country list with flags
In this release, you can now get all the countries of the world and their flags by calling

```java
CountryFlag.getInstance(getApplicationContext()); // loads the countries and flags

final List<Country> countryList = CountryFlag.allCountriesAndFlags(); // all country list
```

Enjoy

---
