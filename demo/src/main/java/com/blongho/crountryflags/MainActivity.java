package com.blongho.crountryflags;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blongho.countryFlags.Objects.Country;
import com.blongho.countryFlags.utils.CountryFlagUtility;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.download);

		CountryFlagUtility.init(getApplicationContext());


		final ImageView imageView1 = (ImageView) findViewById(R.id.flag);
		imageView1.setImageResource(CountryFlagUtility.getFlagOf(752));
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final EditText flag = (EditText) findViewById(R.id.flagtext);
				imageView1.setImageResource(CountryFlagUtility.getFlagOf(flag.getText().toString()));
			}
		});

		Country Sweden = CountryFlagUtility.getCountryFrom("se");

		Log.e(TAG, "onCreate: " + Sweden);

		Log.e(TAG, "onCreate: " + CountryFlagUtility.getCountryFrom("Germany"));

	}

}
