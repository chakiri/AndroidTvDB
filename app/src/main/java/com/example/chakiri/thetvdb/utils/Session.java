package com.example.chakiri.thetvdb.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**  * Created by chakiri */

public class Session {
    private static final String BASE_URL = "https://api.thetvdb.com/";

    public static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
