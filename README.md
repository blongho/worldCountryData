# World Country Data, flags, currency and more - an open source android library for getting country flags and other country attributes

[![](https://jitpack.io/v/blongho/worldCountryData.svg)](https://jitpack.io/#blongho/worldCountryData)
[![CodeFactor](https://www.codefactor.io/repository/github/blongho/worldcountrydata/badge)](https://www.codefactor.io/repository/github/blongho/worldcountrydata)
[![](https://jitci.com/gh/blongho/worldCountryData/svg)](https://jitci.com/gh/blongho/worldCountryData)
![Android CI with Gradle](https://github.com/blongho/worldCountryData/workflows/Java%20CI%20with%20Gradle/badge.svg)

---

An Android library that contains 'all' the flags of the countries of the world
This is to be used for android projects where the developer is interested in
getting the flag of a particular country for any reason.

- A flag is obtained as a drawable resource (int).
- A flag can be set to an ImageView using XML
- There is possibility to get all the countries and their
    flags by invoking just two methods.
---
## System requirement
- Android minSDKversion = 15
- Android targetSDKversion = 31

---
## Usage
1. Add JitPack in your repository build file `build.gradle` (Project appname)
```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

2.1 Add the dependency in your `build.gradle` (Module: app)
```groovy
dependencies {
    //...
    implementation 'com.github.blongho:worldCountryData:$version'
}
```
Replace `$version` with `vXXX` for the most stable version you want to use
see [releases](https://github.com/blongho/worldCountryData/releases)

*Proguard rules*
---
2.2 Add this in your `proguard-rules.pro`
```groovy
-keep class com.blongho.** {*;}
-keep interface com.blongho.**
# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keeppackagenames com.blongho.country_data
-keepclassmembers class com.blongho.country_data.* {
   public *;
}
-keep class com.blongho.country_data.R$*{
    *;
 }
```

2.3 In your `build.gradle` (Module: app)
```groovy
android {
    ...

    buildTypes {
        release {
            minifyEnabled true
            //shrinkResources false // if you set this to true, the application will crash
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
  
    }

    defaultConfig {
        vectorDrawables.useSupportLibrary = true 
    }

    compileOptions {
        sourceCompatibility 1.8
        targetCompatibility 1.8
    }
 ...
}
```
---

3. Build your project (and make sure gradle has successfully synced)
`Buid >> Clean Project, Build >> Rebuild Project`


4. Load all the flags of the world by calling. Do this once in the
    application context.
```java
World.init(getApplicationContext()); // Initializes the libray and loads all data
```
This inititializes the data. All countries are read, and their flags loaded


5. Get the flag of a country(dynamically)
- You can get the flag of a country by using the two iso alpha2 or
    alpha3 or the country name or the numeric code.

```java
// Demonstrating with Sweden
//The attribute is case-insensitive "se == SE == sE == Se"

// use alpha2
final int flag = World.getFlagOf("se"); // use "se" or "sE" or "SE" or "Se"

// use alpha3
final int flag = World.getFlagOf("swe");

// Use country name
final int flag = World.getFlagOf("sweden");

// use country name
final int flag = World.getFlagOf(752);

// Set the image of an imageView
final ImageView swedishFlag= (ImageView) findViewById(R.id.flagImageView);
swedishFlag.setImageResource(flag);

/*
The value of flag is either
- the flag of the country if it is loaded in the library
OR
- a demo flag of the globe (This provides a fall-back and help your app not crash due to nullPointerException)
*/
```

- You can hard-code the country flag if you know the alpha2 code of the country. 
    Eg. to set the flag of Sweden, you could do

```xml
<ImageView android:id="@+id/flagImageId" 
    android:layout_width="@dimens/imageWidth"
    android:layout_height="@dimens/imageHeight"
    android:src="@drawable/se"/> <!-- Sets this image to the Swedish flag -->
```

- In java code, you could statically do same as

```java
// Set the image of an imageView
final ImageView swedishFlag= (ImageView) findViewById(R.id.flagImageView);
swedishFlag.setImageResource(R.drawable.se);
```

6. Get a Country with attributes like `"id":4,"name":"Afghanistan","alpha2":"af","alpha3":"afg", flag:imageResource"`

```java
final Country afghanistan = World.getCountryFrom("af|afg|afghanistan|4");
// Log.d(TAG, afghanistan.toString()); 
```

7. Get a list of all the countries with their identifiers
```java
final List<Country> countries = World.getAllCountries();
// This list cannot be modified but you can get its contents
```

8. Get list of countries from a continent
```java
final List<Country> africanCounties = World.getCountriesFrom(Continent.AFRICA); 
///final List<Country> filteredCountries = World.getCountriesFrom(Continent.[AFRICA|ASIA|EUROPE|OCEANA|SOUTH_AMERICA|NORTH_AMERICA])
// Continent is an enum that has all the continents of the world
```

*NEW*
9. Get the list of languages spoken in a given country
```java
final List<String> languages = country.getLanguages(); 
// Returns comma separated list of country languages e.g [Swedish (sv-SE), Northern Sami (se), Southern Sami (sma), Finnish (fi-SE)]
```
Link to javadoc --> [javadoc link](https://blongho.github.io/worldCountryData/doc/)


**All the steps above are demonstrated in this project -->** [world country flag demo](https://github.com/blongho/world-country-data-demo)

---

| ![Demonstrating dynamic retrieval of country flags](https://github.com/blongho/world-country-data-demo/blob/master/img/animated_gif.gif) |
|:--:|
| *Live retrieval of Country data* |

---

Get this sample app in the playstore 
[![Country Data Demo at playstore](img/playstore.png)](https://play.google.com/store/apps/details?id=com.blongho.countrydata)


<details>
<summary><b>Data sources for the project</b></summary>

### All country flags
Most of the flags came from [flagpedia.net](http://flagpedia.net/download).
This site does not contain all the countries in the world so some where downloaded
from [wikipedia](https://www.wikipedia.org/) after quering the country name

### Countries and their iso alpha values
All country names were download from [Geonames](https://www.geonames.org/countries/) 
using a Python project written by [Bernard Longho aka @blongho](https://github.com/blongho/). Check it out [Countries data by blongho](https://github.com/blongho/countries)


### Getting different dimensions of the flags
Some guys from Egypt made some awesome [App icon generator](https://appicon.co/#image-sets)
which generates android drawables as well as iOS images(if you want) in different dimensions.
It is super fast and can do batch processing of images.
</details>

---

## Contribution guidelines
Please feel free to add more flags or modify any thing that would make this library more useful.
The various ways of contribution are specified in [CONTRIBUTING.md](CONTRIBUTING.md)

---

## Contact
Feel free to [contact me](mailto:blongho02@gmail.com) to discuss anything related to development in particular and life in general.
