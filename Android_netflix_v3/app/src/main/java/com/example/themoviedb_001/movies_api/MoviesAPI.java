package com.example.themoviedb_001.movies_api;

import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

    String key = "?api_key=174aafe00bb16262f58d20bed7ae0987";

    @GET("movie/popular" + key)
    Call<MovieResponse> getPopularMovies();

    @GET("search/movie" + key)
    Call<MovieResponse> searchMovies(@Query("query") String moviename);

    @GET("movie/{id}"+key)
    Call<Movie> getMovieDetails(
            @Path("id") int id);

    @GET("discover/movie" + key)
    Call<MovieResponse> getMoviesByReleaseDate(@Query("primary_release_date.gte") String startDate,
                                               @Query("primary_release_date.lte") String endDate);

    @GET("discover/movie" + key)
    Call<MovieResponse> getMoviesByVoteAverage(@Query("vote_average.gte") double minVoteAverage);

    @GET("discover/movie" + key)
    Call<MovieResponse> getMoviesByPopularity(@Query("sort_by") String sortBy);


}
