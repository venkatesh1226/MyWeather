package com.example.weather;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    String BASE_URL="https://api.openweathermap.org";
    private static RetrofitClient mInstance;
    private  Retrofit retrofit;
    private RetrofitClient(){
        retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }


    public static synchronized RetrofitClient getmInstance(){
        if(mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
