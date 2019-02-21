package com.blongho.crountryflags;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		Log.e("MainActivity", tz.getID());

	}
}
