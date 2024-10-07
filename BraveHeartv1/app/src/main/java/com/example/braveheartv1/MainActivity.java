package com.example.braveheartv1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        private Button btn1;
        private Button btn2;
        private Button btn3;
        private Button btn4;
        private Button btn5;
        private Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botón 1!!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
        private void inicializarComponentes(){
            btn1 = findViewById(R.id.btn1);
            btn2 = findViewById(R.id.btn2);
            btn3 = findViewById(R.id.btn3);
            btn4 = findViewById(R.id.btn4);
            btn5 = findViewById(R.id.btn5);
            btn6 = findViewById(R.id.btn6);
        }
}