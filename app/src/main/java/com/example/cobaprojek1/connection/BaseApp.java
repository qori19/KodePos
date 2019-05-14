package com.example.cobaprojek1.connection;

import android.app.Application;

import com.squareup.picasso.BuildConfig;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApp extends Application {
    public static ApiLogin loginService;
    private String url = "https://yutub-api.herokuapp.com";
    @Override
    public void onCreate() {
        super.onCreate();
        loginService = getRetrofit().create(ApiLogin.class);
    }
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();

    }
    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getHttpLogInterceptor())
                .build();

    }
    private Interceptor getHttpLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new
                HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level;
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            level = HttpLoggingInterceptor.Level.NONE;
        }
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}

