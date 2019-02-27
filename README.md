# world-country-flags
A module that contains all world country flags. 
This is to be used for android projects where the developer is interested in getting the flag of a particular country for any reason.

A country flag is obtained as a drawable resource id. 


## Usage
1. This project is not yet published but you can try it by downloading [country_flags](country_flags) and add to your project as described in [adding library as dependency](https://github.com/MagicMicky/FreemiumLibrary/wiki/Import-the-library-in-Android-Studio#method-2)

2. Build your project (and make sure gradle has successfully synced)

3. If 1, and 2 are successful, you should have this
```
// in build.gradle // Module app
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    ....
    implementation project(':country_flags')
}
```
4. Load all the flags of the world by calling 
```
CountryFlag.getInstance(getApplicationContext());
```

5. Get the flag of a country using 
```
// Demonstrating with Sweden
/* You can get the flag of a country by using the two iso alpha2 or alpha3 or the country name. The attribute is case-insensitive "se == SE == sE == Se"
This gives you a result 
*/

final int flag = CountryFlag.of("se"); // use "se" or "sE" or "SE" or "Se" 
// or
final int flag = CountryFlag.of("swe"); // or 
// 
final int flag = CountryFlag.of("sweden"); 

// Set the image of an imageView
final ImageView flagOfGermany= (ImageView) findViewById(R.id.flag);
flagOfGermany.setImageResource(CountryFlag.of("Germany"));

// The value of flag is either
- the flag of the country if it is loaded in the library
OR
- a demo flag of the globe (This provides a fall-back and help your app not crash due to nullPointerException)
```
NB: As of writing, the flags of
- Antartica
- Svalbard and Jan Mayen
- Heard Island and McDonald

are not included. 

## Data sources for the project

### All country flags
Most of the flags came from [flagpedia.net](http://flagpedia.net/download). This site does not contain all the countries in the world so some where downloaded from [wikipedia](https://www.wikipedia.org/) after quering the country name

### Countries and their iso alpha values 
All country names were download from [GitHub@stafangabos](https://github.com/stefangabos/world_countries/tree/master/data/en). These were copied using into the assets directory

### Getting different dimensions of the flags
Some guys from Egypt made some awesome [App icon generator](https://appicon.co/#image-sets) which generates android drawables as well as iOS images(if you want) in different dimensions. It is supperfast and can do batch processing of images. Please consider [buying them a cup of coffee](https://www.buymeacoffee.com/appiconco) if you find this library useful. 

## Contribution guidelines
Please feel free to add more maps or modify any thing that would make this libray more useful. Follow [First contributions instructions](https://github.com/blongho/first-contributions/blob/master/README.md) and i will be super happy to merge your pull request.

## Next steps
Make this library available for the web usage where one get same ease of use using different programming languages


## Contact
Feel free to [contact me](mailto:blongho02@gmail.com) to discuss anything related to development in particular and life in general. 



