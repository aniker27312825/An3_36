package com.geektech.an3_36;

import android.app.Application;

import com.geektech.an3_36.data.remote.FilmsApi;
import com.geektech.an3_36.data.remote.FilmsApiClient;
import com.geektech.an3_36.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmsApi api;
    public static FilmsApiClient client;

    @Override
    public void onCreate() {
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmsApi();
        super.onCreate();
        client = new FilmsApiClient();
    }
}

