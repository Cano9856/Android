package com.example.pruebamvplogin.login.model;

import com.example.pruebamvplogin.beans.User;
import com.example.pruebamvplogin.login.ContractLoginUser;
import com.example.pruebamvplogin.login.data.UserData;
import com.example.pruebamvplogin.utils.API;
import com.example.pruebamvplogin.utils.MotorRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



//Model completado, falta el presenter y el view

public class LoginModel implements ContractLoginUser.Model {

    private static final String URL = "http://192.168.104.74:3000/";

    @Override
    public void API(User user, listener listener) {
        API apiservice = MotorRetrofit.connection(URL).create(API.class);
        //creamos el motor para hablar con bbdd, lo instanciamos mas bien

        User loggedUser = new User();
        loggedUser.setEmail(user.getEmail());
        loggedUser.setPassword(user.getPassword());


        Call<UserData> call = apiservice.login(loggedUser);


        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()){
                    UserData userData = response.body();
                    if (userData!=null&&userData.getUser()!=null){
                        listener.onFinished(loggedUser);
                    }else{
                        listener.onFailure("No se encontró al usuario");
                    }
                }else{
                    listener.onFailure("Hubo un error inesperado");
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                    listener.onFailure("Hubo un error");
            }
        });

    }
}
