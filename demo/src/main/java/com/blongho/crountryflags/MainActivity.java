package com.blongho.crountryflags;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blongho.countryFlags.Objects.Country;
import com.blongho.countryFlags.utils.CountryFlag;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.download);
		CountryFlag.getInstance(getApplicationContext());
		final ImageView imageView1 = (ImageView) findViewById(R.id.flag);
		imageView1.setImageResource(CountryFlag.of(752));
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final EditText  flag       = (EditText) findViewById(R.id.flagtext);
				imageView1.setImageResource(CountryFlag.of(flag.getText().toString()));
			}
		});

		CountryFlag.getInstance(getApplicationContext()); // Check the Logcat to see if the hashcodes are the same

		final List<Country> countryList = CountryFlag.allCountriesAndFlags();
		for (Country c : countryList) {
			Log.e(TAG, "onCreate: " + c.toString());
		}
	}

}
