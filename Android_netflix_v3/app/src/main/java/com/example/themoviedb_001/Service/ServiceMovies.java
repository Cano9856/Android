package com.example.themoviedb_001.Service;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.themoviedb_001.MainActivity;
import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;
import com.example.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceMovies {


    /*MÉTODO PARA OBTENER LAS PELICULAS MÁS VOTADAS, CONSULTA A MOVIERESPONSE, OBJETO
     QUE GUARDA UN ARRAYLIST DE PELICULAS DE LAS QUE LUEGO LE PIDO EL NOMBRE Y LA DESCRIPCIÓN */
    public void getPopularMovies(Context context) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(); // Para obtener películas populares
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText( context,
                                "Popular Movie: " + movie.getTitle() + "\n" +
                                        "Description: " + movie.getOverview(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error fetching popular movies: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*MÉTODO QUE HACE UNA CONSULTA SIMILAR A LA DE POPULARES PERO ESTE METODO IMPLEMENTA EN MOVIESAPI
    EL @QUERY PARA BUSCAR POR NOMBRE LA PELICULA QUE BUSCAS->[@query("movie_name")]*/
    public void searchMovies(String query,Context context){
        Call<MovieResponse> call = RetrofitClient.getInstance().searchMovies(query); // Para buscar películas por nombre
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(context,
                                "Searched Movie: " + movie.getTitle() + "\n" +
                                        "Description: " + movie.getOverview(),
                                Toast.LENGTH_SHORT).show();

                    }

                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error searching movies: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*MÉTODO PARA RECUPERAR LA PELI EN BASE AL ID QUE LE PASES, PERO COMO SOLO ES UNA PELICULA SOLO LLAMAS
      A MOVIE Y NO A MOVIERESPONSE, SI LO HICIESES DARÍA ERROR AL PEDIR VARIAS CUANDO SOLO ACEPTAS UNA*/
    public void getMovieDetails(int movieId,Context context, TextView txt) {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    txt.setText("");
                    Toast.makeText(context,
                            "Movie Name: " + response.body().getTitle() + "\n" +
                                    "Movie Id: " + response.body().getId() + "\n" +
                                    "Description: " + response.body().getOverview(),
                            Toast.LENGTH_SHORT).show();
                    txt.setText(response.body().getTitle()+ "\n"+" " +response.body().getOverview());
                    //ESTE TXT ES PARA PROBAR A METER LOS RESULTADOS EN UN TEXTVIEW PERO SOLO FUNCIONA EN ESTE CASO,
                    //EN LOS DEMÁS CASOS DE ARRIBA SE IMPRIMEN OTRAS PELICULAS POR ALGÚN MOTIVO QUE DESCONOZCO A 3-10-2024
                }
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(context, "Error fetching movie details: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Obtener películas por fecha de lanzamiento
    public void getMoviesByReleaseDate(String startDate, String endDate, Context context) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByReleaseDate(startDate, endDate);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(context,
                                "Release Date Movie: " + movie.getTitle() + "\n" +
                                        "Release Date: " + movie.getRelease_date(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error fetching movies by release date: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Obtener películas por media de votos
    public void getMoviesByVoteAverage(double minVoteAverage, Context context) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByVoteAverage(minVoteAverage);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(context,
                                "Vote Average Movie: " + movie.getTitle() + "\n" +
                                        "Average Votes: " + movie.getVote_average(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error fetching movies by vote average: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Obtener películas por popularidad
    public void getMoviesByPopularity(String sortBy, Context context) {
        Call<MovieResponse> call = RetrofitClient.getInstance().getMoviesByPopularity(sortBy);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(context,
                                "Popular Movie: " + movie.getTitle() + "\n" +
                                        "Popularity: " + movie.getPopularity(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, "Error fetching movies by popularity: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
