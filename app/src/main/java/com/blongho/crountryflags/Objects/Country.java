package com.blongho.crountryflags.Objects;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Bernard Che Longho (blongho) This class is built inorder to extract the files located at <br>
 * @file Country.java
 * @brief A country is represented by the name, the 2 letter representation, the 3 letter representation
 * @see https://raw.githubusercontent.com/stefangabos/world_countries/master/data/en/world.json A sample output of the
 * 	file is
 **/

public class Country {
	private String name;
	private String alpha2;
	private String alpha3;
	@DrawableRes
	private int flagResource;

	private Country(final Builder builder){
		name = builder.name;
		alpha2 = builder.alpha2;
		alpha3 = builder.alpha3;
		flagResource = builder.flagResource;
	}

	public static class Builder{
		private String name;
		private String alpha2;
		private String alpha3;
		@DrawableRes
		private int flagResource;


		public Builder setCountryName(final String name){
			this.name = name;
			return this;
		}

		public Builder setCountryAlpha2(final String alpha2){
			this.alpha2 = alpha2;
			return this;
		}

		public Builder setCountryAlpha3(final String alpha3){
			this.alpha3 = alpha3;
			return this;
		}

		public Builder setCountryFlag(@DrawableRes final int flagResource){
			this.flagResource = flagResource;
			return this;
		}

		public Country create(){
			return new Country(this);
		}
	}

	public String getName() {
		return name;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public int getFlagResource() {
		return flagResource;
	}

	@Override
	public String toString() {
		return "Country{" + "name='" + name + '\'' + ", alpha2='" + alpha2 + '\'' + ", alpha3='" + alpha3 + '\'' + ", " +
			   "flagResource=" + flagResource + '}';
	}
}