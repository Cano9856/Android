package com.example.themoviedb_001;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedb_001.Service.ServiceMovies;
import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;
import com.example.themoviedb_001.movies_api.MoviesAPI;
import com.example.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //public static Context contextMain;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceMovies srv = new ServiceMovies();

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        txt = findViewById(R.id.movietext);

        btn1.setOnClickListener(v -> srv.getPopularMovies(getBaseContext()));
        btn2.setOnClickListener(v -> srv.searchMovies("Titanic",getBaseContext())); // Cambia el nombre de la película según sea necesario
        btn3.setOnClickListener(v -> srv.getMovieDetails(550,getBaseContext(),txt)); // Cambia el ID según sea necesario
    }

}
