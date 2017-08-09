package com.akshay.retrogson.dagger.modules;

import com.akshay.retrogson.Api;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by akshaymahajan on 03/08/17.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new StethoInterceptor());
        return builder;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Api getMockApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
