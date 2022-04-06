/*
 * MIT License
 *
 * Copyright (c) 2019 - 2022 Bernard Longho
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.blongho.country_data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A country is represented by the name, the 2 letter representation, the 3
 * letter representation
 * <br>
 * The Country data were gotten from the sister project by same author from
 * https://github.com/blongho/countries <br>
 * A sample entry of the file is { "id": "020", "alpha2":
 * "AD", "alpha3": "AND", "name": "Andorra", "capital": "Andorra la Vella",
 * "area": "468.0",
 * "population": "84,000", "continent": "EU" } *
 * <p>
 * The user should not be able to create a new
 * Country as in real life, countries are not just created.
 * </p>
 *
 * @author Bernard Che Longho (blongho)
 * @since 2020-02-29
 **/

public class Country implements Parcelable {

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
    private final static Map<String, String> CONTINENTS = Collections
            .unmodifiableMap(new HashMap<String, String>() {
                {
                    put("AF", "Africa");
                    put("AS", "Asia");
                    put("NA", "North America");
                    put("SA", "South America");
                    put("OC", "Oceania");
                    put("EU", "Europe");
                    put("AN", "Antarctica");
                    put("UNX", "Universe"); // Dummy for World
                }
            });
    private final String id; // The country's ISO 3166-1 numeric id
    private final String name; // The official name of the country
    private final String alpha2; // The country's ISO 3166 alpha2 id
    private final String alpha3; // The country's ISO 3166 alpha3 id
    private final String capital;
    private final String continent;
    private final String area;
    private final String population;
    @DrawableRes
    private int flagResource; // The image resource that represent the country flag
    private Currency currency;

    /**
     * @param id           The numeric code of the country
     * @param name         The name of the country
     * @param alpha2       The country's ISO 3166 alpha2 id
     * @param alpha3       The country's ISO 3166 alpha3 id
     * @param capital      The official capital of the country
     * @param continent    The continent where the country is found
     * @param area         The surface area of the country
     * @param population   The population of the country
     * @param flagResource The country flag
     * @param currency     The currency of the country
     */
    Country(String id, String name, String alpha2, String alpha3, String capital,
            String continent, String area, String population, @DrawableRes int flagResource,
            Currency currency) {
        this.id = id;
        this.name = name;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.capital = capital;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.flagResource = flagResource;
        this.currency = currency;
    }

    protected Country(Parcel in) {
        id = in.readString();
        name = in.readString();
        alpha2 = in.readString();
        alpha3 = in.readString();
        capital = in.readString();
        continent = in.readString();
        area = in.readString();
        population = in.readString();
        flagResource = in.readInt();
        currency = in.readParcelable(Currency.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(alpha2);
        parcel.writeString(alpha3);
        parcel.writeString(capital);
        parcel.writeString(continent);
        parcel.writeString(area);
        parcel.writeString(population);
        parcel.writeInt(flagResource);
        parcel.writeParcelable(currency, flags);
    }

    /**
     * @return The Capital City of the Country
     */
    public final String getCapital() {
        return capital;
    }

    /**
     * Get the name of the country
     *
     * @return The country name
     */
    public final String getName() {
        return name;
    }

    /**
     * Get the alpha2 of the country
     *
     * @return The ISO 3166 alpha2 id of the country
     */
    public final String getAlpha2() {
        return alpha2;
    }

    /**
     * Get the alpha3 of the country
     *
     * @return The ISO 3166 alpha3 id of the country
     */
    public final String getAlpha3() {
        return alpha3;
    }

    /**
     * Get the image resource of the country
     *
     * @return The R.drawable.id representing the flag of the country
     */
    public final int getFlagResource() {
        return flagResource;
    }

    /* package */
    void setFlagResource(@DrawableRes final int flagResource) {
        this.flagResource = flagResource;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (alpha2 != null ? alpha2.hashCode() : 0);
        result = 31 * result + (alpha3 != null ? alpha3.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) {
            return false;
        }
        if (name != null ? !name.equals(country.name) : country.name != null) {
            return false;
        }
        if (alpha2 != null ? !alpha2.equals(country.alpha2) : country.alpha2 != null) {
            return false;
        }
        return alpha3 != null ? alpha3.equals(country.alpha3) : country.alpha3 == null;
    }

    @Override
    @NonNull
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alpha2='" + alpha2 + '\'' +
                ", alpha3='" + alpha3 + '\'' +
                ", capital='" + capital + '\'' +
                ", continent='" + getContinent() + '\'' +
                ", area='" + getArea() + '\'' +
                ", population='" + getPopulation() + '\'' +
                ", currency=" + currency +
                '}';
    }

    /**
     * @return The Geographical continent of the Country
     */
    public final String getContinent() {
        return CONTINENTS.get(continent);
    }

    /**
     * @return The Surface Area of the country (sq. kilometers)
     */
    public final double getArea() {
        String tmp = formatStringToNumber(area);
        return Double.parseDouble(tmp.replace(".0", ""));
    }

    /**
     * @return The total population of the country
     */
    public final long getPopulation() {
        return Long.parseLong(formatStringToNumber(population));
    }

    /**
     * Format area and population data to a suitable way so that it can be parsed to
     * Integral types
     *
     * @param unformatted The unformatted string {xx,xxx,xxx,xxx}
     * @return a string with all commas (,) removed
     */
    private String formatStringToNumber(String unformatted) {
        return unformatted.replaceAll(",", "");
    }

    /**
     * Get the currency for this country
     *
     * @return The country currency
     */
    public final Currency getCurrency() {
        return currency;
    }

    /* package */
    void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    /* package */
    boolean hasProperty(final String attribute) {
        return attribute.equalsIgnoreCase(alpha2) || attribute.equalsIgnoreCase(alpha3)
                || attribute.equalsIgnoreCase(name) || attribute.equalsIgnoreCase(String.valueOf(getId()));
    }

    /**
     * Unique id for each Country
     *
     * @return The country's ISO 3166-1 numeric id
     */
    public final int getId() {
        return Integer.parseInt(id);
    }
}
