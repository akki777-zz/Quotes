package com.akshay.retrogson.utils.rx;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by akshaymahajan on 01/08/17.
 */

public class RxApiUtil {

    public static <T> Observable<T> build(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
