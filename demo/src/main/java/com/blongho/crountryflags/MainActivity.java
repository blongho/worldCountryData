package com.blongho.crountryflags;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blongho.countryFlags.Country;
import com.blongho.countryFlags.World;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = findViewById(R.id.download);

		World.init(getApplicationContext());

		final ImageView imageView1 = (ImageView) findViewById(R.id.flag);
		imageView1.setImageResource(World.getFlagOf(752));
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final EditText flag = (EditText) findViewById(R.id.flagtext);
				imageView1.setImageResource(World.getFlagOf(flag.getText().toString()));
			}
		});

		Country Sweden = World.getCountryFrom("se");

		Log.e(TAG, "onCreate: " + Sweden);

		Log.e(TAG, "onCreate: " + World.getCountryFrom("Germany"));

		Country cmr = World.getCountryFrom("cameroon");
		Log.e(TAG, "onCreate: " + cmr);

		Country afg = World.getCountryFrom(4);
		Log.e(TAG, "onCreate: " + afg);
	}

}
