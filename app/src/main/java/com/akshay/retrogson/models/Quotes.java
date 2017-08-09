package com.akshay.retrogson.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by akshaymahajan on 01/08/17.
 */

@Parcel
public class Quotes {

    @SerializedName("quoteText")
    public String quote;

    @SerializedName("quoteAuthor")
    public String author;
}
