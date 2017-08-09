package com.akshay.retrogson.utils.rx;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by akshaymahajan on 02/08/17.
 */

public class RxViewUtil {

    public static Observable<Object> click(View view, long millis) {
        return RxView.clicks(view)
                .throttleFirst(millis, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
