package com.akshay.retrogson.dagger.components;

import android.app.Application;

import com.akshay.retrogson.dagger.modules.AppModule;
import com.akshay.retrogson.dagger.modules.NetworkModule;
import com.akshay.retrogson.dagger.modules.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by akshaymahajan on 04/08/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RetrofitModule.class})
public interface Graph extends AppComponent, NetworkComponent {

    final class Initialiser {
        public static Graph initialize(Application app) {
            return DaggerGraph.builder()
                    .retrofitModule(new RetrofitModule())
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
