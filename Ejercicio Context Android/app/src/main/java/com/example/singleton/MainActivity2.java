package com.example.singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.singleton.services.ServicePantallaPrincipal;

public class MainActivity2 extends AppCompatActivity {
    private Button btnSaludar2;
    private ServicePantallaPrincipal spPrincipal;

    /////// PATRÓN SINGLETON
    private static MainActivity2 padre;
    public static MainActivity2 getInstance(){
        return padre;
    }
    // FIN PATRÓN SINGLETON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_segunda_activity);

        btnSaludar2 = findViewById(R.id.btnSaludar2);
        spPrincipal = new ServicePantallaPrincipal();

        this.padre= this;

        btnSaludar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spPrincipal.altaUsuario();
            }
        });

    }
}