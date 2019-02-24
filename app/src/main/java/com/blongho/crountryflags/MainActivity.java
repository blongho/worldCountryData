package com.blongho.crountryflags;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blongho.crountryflags.Objects.Country;
import com.blongho.crountryflags.utils.Scrapper;

import org.jsoup.nodes.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

	private final static String PACKAGE = "com.blongho.crountryflags";
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		Log.e("MainActivity", tz.getID());
		Button button = (Button)findViewById(R.id.download);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				runScrapper();
			}
		});

		Country cameroon = new Country.Builder()
			.setCountryAlpha2("cm")
			.setCountryAlpha3("cmr")
			.setCountryName("Camerooon")
			.setCountryFlag(R.drawable.cm)
			.create();

		Log.e(TAG, cameroon.toString());

		final ImageView imageView1 = (ImageView)findViewById(R.id.imageView);
		imageView1.setImageResource(R.drawable.ad);

		Field[]             drawablesFields = com.blongho.crountryflags.R.drawable.class.getFields();
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
		}
		loadDrawables(R.drawable.class);

	}

	private void runScrapper() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				Scrapper.scrappedContent();
			}
		}).start();
	}

	public  void loadDrawables(Class<?> clz){
		TextView view = (TextView)findViewById(R.id.textView);
		final Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			final int drawableId;
			try {
				drawableId = field.getInt(clz);
			} catch (Exception e) {
				continue;
			}
			if(drawableId == R.drawable.cm){
				Log.e(TAG, "Cameroon");
			}
		}
	}

}
