package com.example.pruebamvplogin.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MotorRetrofit {

    private static Retrofit retrofit= null;

    public static Retrofit connection(String url){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;
    }




}
