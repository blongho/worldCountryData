**May 13 2019 : v1.2.0**

Stable release of v1.2.0-beta

---

**May 11 2019 : v1.2.0-beta**

Do you want to know the most populated country in the world or the smallest country of the world or you are planning on a vacation and you want to know the main city (capital city)?

In this release, you are now able to do the following

- get the country population
- get the capital city of the country
- get the surface area of the country
- get the continent of a country

==> Check the java documentation for more https://blongho.github.io/worldCountryData/doc/

This is a pre-release, it has not been thoroughly tested. Report any bugs by creating an issue

In the future release, it will be possible to get the cities (all major cities) of any country and more more...

**Mar 14 2019: v1.1.0** 

Changes made

1. Changed library package from `countryFlags` to `country_data`.
The latter better conveys the information contained in the library.
The former had only country flags as extra information apart from the
country identifiers. This version and upcoming versions will have more
information about a country.
2. Cleaned code base and improve documentation
The current version have the currency for each country. Subsequent
versions will have more country data
---

**Mar 11 2019: v1.1-beta**

It is now possible to get the list of currencies of the world
```java
World.init(getApplicationContext()); // initialize data
List<Currency> currencies = World.getAllCurrencies()
// Currency [country=NZ, name=New Zealand Dollars, code=NZD, symbol=$]
```
---
**Mar 8 2019: v1.1-alpha**

In this release, one a Country also has a Currency

Get the currency from a country by calling
```java
World.init(getApplicationContext());
Country cameroon = World.getCountryFrom("cm");
Currency curr = cameroon.getCurrency();
```
---

**Mar 5 2019 : v1.0**

This release is provides a more intuitive interface for the user. 

Major changes include:

1. Removal of ability of user to create a country in their app.
In real world, countries are not created like that.

2. To get a country, a user has to know any of the four identifiers of the country

The country name eg Sweden

The country numeric code eg 752

The alpha2 of the country eg "se"

The alpha3 of the country eg "swe"

With these, Sweden can be created alongside its flag using

```java
World.init(getApplicationContext()); 
// you call this just once in your program. It wraps a singleton 
// that initializes everything that the library is to offer
Country sweden = World.getCountryFrom("sweden"|"se"|"swe"|752); 
```
4. To get the flag of a country, the user needs any of the identifiers mensioned in 2 above, then using two methods
```java
World.init(getApplicationContext());
final int swedishFlag = World.getFlagOf("sweden"|"se"|"swe"|752);
```
5. If you are interested in all the countries of the world
```java
World.init(getApplicationContext());
final List<Country> countries = World.getAllCountries(); 
// This list cannot be modified by adding, sorting or removing an element. 
// You can only retrieve information therein
```
NB: All Country identifiers have getters so you can use that to retrieve a Country
from `List<Country> countries`
Give a star to the repository to get updates of new features.

---
**Feb 28 2019 : v0.1.1**
In this release, you can now get all the countries of the world and their flags by calling
```java
CountryFlag.getInstance(getApplicationContext()); // loads the countries and flags

final List<Country> countryList = CountryFlag.allCountriesAndFlags(); // all country list
```
Enjoy

---
**Feb 27 2019:  v0.1.0**
* Get counry flag using country code or country name