package com.example.themoviedb_001.movies_api;


import com.example.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.http.GET;
import retrofit2.Call;

public interface MoviesAPI {
    @GET("movie/popular?api_key=174aafe00bb16262f58d20bed7ae0987")
    Call<MovieResponse> getPopularMovies();

}
