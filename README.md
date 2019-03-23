# World Country flags, currency and more - an open source android library for getting country flags and other country attributes
[![](https://jitpack.io/v/blongho/world-country-data.svg)](https://jitpack.io/#blongho/world-country-data)

An Android library that contains 'all' the flags of the countries of the world
This is to be used for android projects where the developer is interested in
getting the flag of a particular country for any reason.

- A flag is obtained as a drawable resource (int).
- A flag can be set to an ImageView using XML
- There is possibility to get all the countries and their flags by invoking just two methods.

---

## System requirement
- Android minSDKversion = 15
- Android targetSDKversion = 28

---

## Usage
1. Add JitPack in your respository build file `build.gradle`
```xml
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Get the latest commit from the master branch by including
```xml
dependencies {
    ...
    implementation 'com.github.blongho:world-country-data:master-SNAPSHOT'
}
```
Replace `master-SNAPSHOT` with `vXXX` for the most stable 
version [![](https://jitpack.io/v/blongho/world-country-data.svg)](https://jitpack.io/#blongho/world-country-data) 
or any earlier version from [releases](https://github.com/blongho/world-country-data/releases))


3. Build your project (and make sure gradle has successfully synced)
`Buid >> Clean Project, Build >> Rebuild Projeect`


4. Load all the flags of the world by calling. Do this once in the
    application context.
```java
World.init(getApplicationContext());
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

7. Get a list of all the countries with their identifies
```java
final List<Country> countries = World.getAllCountries();
// This list cannot be modified but you can get its contents
```

---

**Checkout the full documentation from** [World country data documentation](https://blongho.github.io/world-country-data/doc/)

---  

- Live demo 

![Demonstrating dynamic retrieval of country flags](https://github.com/blongho/world-country-flag-demo/blob/master/word-country-flag-demo.gif)

- Get the source code for the demo from [world country flag demo](https://github.com/blongho/world-country-flag-demo)

---

<details>
<summary><b>Data sources for the project</b></summary>

### All country flags
Most of the flags came from [flagpedia.net](http://flagpedia.net/download).
This site does not contain all the countries in the world so some where downloaded
from [wikipedia](https://www.wikipedia.org/) after quering the country name

### Countries and their iso alpha values
All country names were download from
[GitHub@stafangabos](https://github.com/stefangabos/world_countries/tree/master/data/en).
These were copied using into the assets directory

### Getting different dimensions of the flags
Some guys from Egypt made some awesome [App icon generator](https://appicon.co/#image-sets)
which generates android drawables as well as iOS images(if you want) in different dimensions.
It is super fast and can do batch processing of images.
</details>

---

## Contribution guidelines
Please feel free to add more flags or modify any thing that would make this libray more useful.
Follow [First contributions instructions](https://github.com/blongho/first-contributions/blob/master/README.md)
and i will be super happy to merge your pull request.

If you are particularly generous, you can
<a href="https://www.buymeacoffee.com/lKmSQRsaU" title="Click to buy a cup of coffee for blongho"><img src="https://www.buymeacoffee.com/assets/img/custom_images/purple_img.png" height="32"></a>

---

## Contact
Feel free to [contact me](mailto:blongho02@gmail.com) to discuss anything related to development in particular and life in general.

**If you use this in your application, please let me know**

---
[MIT License](https://github.com/blongho/world-country-data/blob/master/LICENSE.txt) <br>
Copyright (c) 2019 [Bernard Che Longho](mailto:blongho02@gmail.com)
