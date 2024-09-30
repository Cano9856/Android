package com.example.pasoparametros;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {

    private TextView txtUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txtUser= findViewById(R.id.textUserPantalla2);

    }

}
