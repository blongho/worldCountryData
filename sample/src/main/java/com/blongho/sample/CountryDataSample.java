/*
 * MIT License
 *
 * Copyright (c) 2019 - 2020 Bernard Che Longho
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

package com.blongho.sample;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.blongho.country_data.Country;
import com.blongho.country_data.Currency;
import com.blongho.country_data.World;
import com.google.android.material.textfield.TextInputEditText;
import java.text.NumberFormat;
import java.util.Locale;

public class CountryDataSample extends AppCompatActivity {

  private ImageView flag = null; // the flag view
  private TextInputEditText identifier = null; // edit text
  private TextView countryName = null; // the country name
  private TextView alpha2; // the country iso alpha2
  private TextView alpha3; // the country iso alpha3
  private TextView code; // the country numeric code
  private TextView currency; // the currency of the country
  private TextView capital, area, population, continent;
  private String entered; // the value entered by the user
  private Country country;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_country_data_sample);
    // 1.  Initialize the library
    World.init(getApplicationContext());

    flag = findViewById(R.id.flag);

		/*
		2.
		Set the flag to be that of the globe.
		Change this to
		flag.setImageResource(World.getFlagOf(724));
		Rur-run the app. What do you notice?
		*/
    flag.setImageResource(
        World.getWorldFlag()); // This overrides the value set in activity_main.xml line 18

    countryName = findViewById(R.id.countryName);
    identifier = findViewById(R.id.identifier);

    // Do you want to get the country and flag dynamically, it as simple as below

    alpha2 = findViewById(R.id.alpha2);
    alpha3 = findViewById(R.id.alpha3);
    code = findViewById(R.id.numericCode);
    currency = findViewById(R.id.currency);
    area = findViewById(R.id.area);
    population = findViewById(R.id.population);
    capital = findViewById(R.id.capital);
    continent = findViewById(R.id.continent);
    identifier.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(
          final CharSequence s, final int start, final int count, final int after) {

      }

      @Override
      public void onTextChanged(
          final CharSequence s, final int start, final int before, final int count) {
        entered = String.valueOf(s).trim();
        if (isEmulator()) {
          InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(
              Context.INPUT_METHOD_SERVICE);
          assert inputMethodManager != null;
          inputMethodManager.hideSoftInputFromWindow(identifier.getWindowToken(), 0);

        }
      }

      @Override
      public void afterTextChanged(final Editable s) {
        flag.setImageResource(World.getFlagOf(entered));
        country = World.getCountryFrom(entered);

        // Interested in the currency, get it by
        // final Currency currency = country.getCurrency();

        // See what a country object is
        if (country.getFlagResource() != World.getWorldFlag()) {
          countryName.setText(country.getName());
          alpha2.setText(country.getAlpha2());
          alpha3.setText(country.getAlpha3());
          code.setText(String.valueOf(country.getId()));
          area.setText(
              NumberFormat.getInstance(Locale.getDefault()).format(country.getArea()) + " sq. km");
          capital.setText(country.getCapital());
          population.setText(
              NumberFormat.getInstance(Locale.getDefault()).format(country.getPopulation()));
          continent.setText(country.getContinent().toUpperCase());
          final Currency curr = country.getCurrency();
          if (curr != null) {
            currency.setText(String.format("Currency: %s", curr.toString()));
          }
        }
      }
    });
  }

  private boolean isEmulator() {
    return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
        || Build.FINGERPRINT.startsWith("generic")
        || Build.FINGERPRINT.startsWith("unknown")
        || Build.HARDWARE.contains("goldfish")
        || Build.HARDWARE.contains("ranchu")
        || Build.MODEL.contains("google_sdk")
        || Build.MODEL.contains("Emulator")
        || Build.MODEL.contains("Android SDK built for x86")
        || Build.MANUFACTURER.contains("Genymotion")
        || Build.PRODUCT.contains("sdk_google")
        || Build.PRODUCT.contains("google_sdk")
        || Build.PRODUCT.contains("sdk")
        || Build.PRODUCT.contains("sdk_x86")
        || Build.PRODUCT.contains("vbox86p")
        || Build.PRODUCT.contains("emulator")
        || Build.PRODUCT.contains("simulator");
  }
}

