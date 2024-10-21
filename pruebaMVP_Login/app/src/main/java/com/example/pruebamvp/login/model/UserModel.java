package com.example.pruebamvp.login.model;

import com.example.pruebamvp.beans.User;
import com.example.pruebamvp.login.ContractUser;
import com.example.pruebamvp.login.data.UserData;
import com.example.pruebamvp.utils.API;
import com.example.pruebamvp.utils.MotorRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserModel implements ContractUser.Model {

    private static final String url = "http://192.168.80.1:3000/";

    @Override
    public void API(User user, loginListener listener) {
        //CREAMOS EL SERVICIO DE API
        API apiService = MotorRetrofit.connection(url).create(API.class);

        //GUARDAMOS LOS DATOS DEL USUARIO QUE NOS LLEGA PARA MANDARLO DESPUÉS
        User loggedUser = new User();
        loggedUser.setEmail(user.getEmail());
        loggedUser.setPassword(user.getPassword());

        //ENVIAMOS LA LLAMADA CON LOS DATOS DEL USUARIO
        Call<UserData> call = apiService.login(loggedUser);

        //MANEJAMOS LA RESPUESTA DEL SERVIDOR FRENTE A LA PETICION DE INICIO DE SESION
        call.enqueue(new Callback<UserData>() {
            //COMPROBAMOS LA RESPUESTA QUE DA EL SERVIDOR
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()){
                    UserData userData = response.body();
                    if (userData!=null && userData.getUser()!=null){
                        listener.onFinished(loggedUser);
                    }else{
                        listener.onFailure("No se encontró el usuario");
                    }
                }else{
                    listener.onFailure("Hubo un error");
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                    listener.onFailure("Hubo un error");
            }
        });

    }
}
