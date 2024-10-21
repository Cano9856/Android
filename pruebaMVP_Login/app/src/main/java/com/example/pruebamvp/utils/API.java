package com.example.pruebamvp.utils;

import com.example.pruebamvp.beans.User;
import com.example.pruebamvp.login.data.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

//    @GET("movies")
//    Call<DataMovies> getAllMovies();

    @POST("login")
    Call<UserData> login(@Body User user);


}
