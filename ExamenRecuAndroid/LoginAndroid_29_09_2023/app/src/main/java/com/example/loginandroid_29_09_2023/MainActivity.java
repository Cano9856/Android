package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.loginandroid_29_09_2023.lstMov.view.*;

public class MainActivity extends AppCompatActivity{
    private static final long SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Intent mainIntent = new Intent(MainActivity.this, LstMovies.class);
//        startActivity(mainIntent);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                try {
                    Intent mainIntent = new Intent(MainActivity.this,
                            LstMovies.class);
                    startActivity(mainIntent);
                    MainActivity.this.finish();
                }catch (Exception err){
                    throw new RuntimeException(err);
                }

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}