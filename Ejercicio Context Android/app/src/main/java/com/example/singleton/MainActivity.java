package com.example.singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.singleton.services.ServicePantallaPrincipal;

public class MainActivity extends AppCompatActivity {
    private Button btnSaludar;
    // onLoad: Javascript  == onCreate: Java //

    /////// PATRÓN SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance(){
        return padre;
    }
    // FIN PATRÓN SINGLETON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton
        this.padre= this;
        //Fin singleton

        ServicePantallaPrincipal service = new ServicePantallaPrincipal();
        //ServicePantallaPrincipal service1 = new ServicePantallaPrincipal();

        btnSaludar=findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.saludar();
            }
        });

        //INVESTIGAR INTENT (OBJETIVO: NAVEGAR DE UNA PANTALLA A OTRA)
            //TECNICAMENTE SON SOLO DOS LINEAS DE CÓDIGO

    }
}