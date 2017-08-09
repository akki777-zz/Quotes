package com.akshay.retrogson;

import com.akshay.retrogson.models.Quotes;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by akshaymahajan on 01/08/17.
 */

public interface Api {
    @GET("/api/1.0/?method=getQuote&format=json&lang=en")
    Observable<Quotes> getQuotes();
}
