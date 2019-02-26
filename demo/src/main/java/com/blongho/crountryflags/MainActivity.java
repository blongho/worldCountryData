package com.blongho.crountryflags;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blongho.crountryflags.Objects.Country;
import com.blongho.crountryflags.utils.ContentReader;
import com.blongho.crountryflags.utils.CountryFlag;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.download);
		/*CountryFlag.getInstance(getApplicationContext());
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final ImageView imageView1 = (ImageView)findViewById(R.id.flag);
				final EditText flag = (EditText)findViewById(R.id.flagtext);
				imageView1.setImageResource(CountryFlag.of(flag.getText().toString().trim()));
			}
		});



		Country cameroon = new Country("Cameroon", null, null, CountryFlag.of("cmr"));
		CountryFlag.getInstance(getApplicationContext());
		//Log.e(TAG, cameroon.toString());



		/*Field[]             drawablesFields = com.blongho.crountryflags.R.drawable.class.getFields();
		ArrayList<Drawable> drawables       = new ArrayList<>();

		for (Field field : drawablesFields) {
			try {
				String value = "com.your.project.R.drawable." + field.getName();
				//Log.e(TAG,value);
				//Log.i("LOG_TAG", value.substring(value.length()-2));
				drawables.add(getResources().getDrawable(field.getInt(null)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
/*
//		loadDrawables(R.drawable.class);
		final List<Country> countriesWithoutFlag = new ArrayList<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				final String values = ContentReader.readFromAssets(getApplicationContext(), "countries.json");
				Gson gson = new Gson();
				Country[] countries = gson.fromJson(values, Country[].class);
				Log.e( "Number of countries", String.valueOf(countries.length));
				for (Country country : countries) {
					country.setFlagResource(CountryFlag.of(country.getAlpha2()));
					if(country.getFlagResource() == -1){
						countriesWithoutFlag.add(country);
					}else
						Log.e(TAG, country.toString());
				}

			}
		}).start();
*/



	}


}
