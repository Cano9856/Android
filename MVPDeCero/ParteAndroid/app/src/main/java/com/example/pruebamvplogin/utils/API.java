package com.example.pruebamvplogin.utils;

import com.example.pruebamvplogin.beans.User;
import com.example.pruebamvplogin.login.data.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @POST("login")
    Call<UserData> login(@Body User user);



}
