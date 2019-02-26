package com.blongho.crountryflags;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blongho.countryFlags.Objects.Country;
import com.blongho.countryFlags.utils.CountryFlag;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.download);
		CountryFlag.getInstance(getApplicationContext());
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final ImageView imageView1 = (ImageView) findViewById(R.id.flag);
				final EditText  flag       = (EditText) findViewById(R.id.flagtext);
				imageView1.setImageResource(CountryFlag.of(flag.getText().toString().trim()));
			}
		});

		Country cameroon = new Country("Sweden", "se", "swe", CountryFlag.of("sweden"));
		CountryFlag.getInstance(getApplicationContext()); // Check the Logcat to see if the hashcodes are the same
	}

}
