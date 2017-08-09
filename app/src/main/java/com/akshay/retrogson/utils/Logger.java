package com.akshay.retrogson.utils;

import android.support.compat.BuildConfig;
import android.util.Log;

/**
 * Created by akshaymahajan on 02/08/17.
 */

public class Logger {

    public static final String TAG = Logger.class.getSimpleName();

    public static void log(String tag, Object object) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, "" + object);
        }
    }

    public static void logException(String tag, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, "" + throwable);
        }
    }
}
