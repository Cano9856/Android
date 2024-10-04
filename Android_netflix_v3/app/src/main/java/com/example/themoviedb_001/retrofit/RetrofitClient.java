package com.example.themoviedb_001.retrofit;

import com.example.themoviedb_001.json_mapper.MovieResponse;
import com.example.themoviedb_001.movies_api.MoviesAPI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static final String API_KEY = "?api_key=174aafe00bb16262f58d20bed7ae0987";
   // private static final String POPULAR_URL = "https://api.themoviedb.org/3/movie/popular";
   //private static final String SEARCH_URL = "search/movie";
    private static MoviesAPI instance;

    public static MoviesAPI getInstance() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            instance = retrofit.create(MoviesAPI.class);
        }

        return instance;
    }





//    public static String getMovieDetailsUrl(int movieId) {
//        String url = BASE_URL + "movie/" + movieId + "?api_key=" + API_KEY;  //PARA VER SI LA URL SERÍA CORRECTA
//        System.out.println(url);
//        return url;
//    }

}
