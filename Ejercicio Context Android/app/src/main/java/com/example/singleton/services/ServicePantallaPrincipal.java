package com.example.singleton.services;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singleton.MainActivity;
import com.example.singleton.MainActivity2;

public class ServicePantallaPrincipal {

    public ServicePantallaPrincipal() {

    }

    public void saludar(){
        Toast.makeText(MainActivity.getInstance(),
                "Saludar a Android",
                Toast.LENGTH_SHORT).show();
    }
    public void altaUsuario(){
        Toast.makeText(MainActivity2.getInstance(), "Hola segunda pantalla!!!", Toast.LENGTH_SHORT).show();
    }

//    public void Actionsaludar(Context context){
//        Toast.makeText(context,
//                "Saludar a Android",
//                Toast.LENGTH_SHORT).show();
//    }


}
