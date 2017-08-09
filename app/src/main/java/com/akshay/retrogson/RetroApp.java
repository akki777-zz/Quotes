package com.akshay.retrogson;

import android.app.Application;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.akshay.retrogson.dagger.components.Graph;
import com.facebook.stetho.Stetho;

/**
 * Created by akshaymahajan on 01/08/17.
 */

public class RetroApp extends Application {

    public static Typeface CAKE;
    public static Typeface INDIE;

    private static RetroApp mInstance;
    private Graph component;

    public RetroApp(){}

    static RetroApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Stetho.initializeWithDefaults(this);

        component = Graph.Initialiser.initialize(this);
        component.inject(this);

        initialiseFonts();
    }

    public Graph component() {
        return component;
    }

    private void initialiseFonts() {
        CAKE = Typeface.createFromAsset(getAssets(), "fonts/Cake.ttf");
        INDIE = Typeface.createFromAsset(getAssets(), "fonts/Indie-Flower.ttf");
    }

    public boolean isInternetAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void showToastWithInternetHandling(@StringRes int msg) {
        if (!isInternetAvailable()) {
            msg = R.string.connect_to_internet;
        }
        showToast(msg);
    }

    private void showToast(@StringRes int msg) {
        Toast.makeText(mInstance, msg, Toast.LENGTH_SHORT).show();
    }
}