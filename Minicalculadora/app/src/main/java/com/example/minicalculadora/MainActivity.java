package com.example.minicalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


            private EditText edt1;
            private EditText edt2;
            private Button btnSumar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btnSumar = findViewById(R.id.btnSumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena1= edt1.getText().toString();
                String cadena2= edt2.getText().toString();
                int num1= Integer.parseInt(cadena1);
                int num2= Integer.parseInt(cadena2);
                int resultado = num1 + num2;

                Toast.makeText(MainActivity.this, "El resultado de la suma es: " +resultado , Toast.LENGTH_SHORT).show();
            }
        });

    }
}