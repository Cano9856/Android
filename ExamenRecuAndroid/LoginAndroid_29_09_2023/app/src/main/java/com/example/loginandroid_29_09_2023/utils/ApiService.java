package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.lstMov.data.DataMovies;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerCategoriasData;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerLibrosData;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerLibrosPorCategoriaData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //public static final String URL ="http://192.168.104.50:8080/untitled_war_exploded/";
    public static final String URL ="http://192.168.104.52:3000";


    // Example: 192.168.104.50:3000/login
      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })

    @GET("/libros")
    Call<ObtenerLibrosData> ObtenerLibros();

    @GET("/categorias")
    Call<ObtenerCategoriasData> ObtenerCategorias();

    @GET("/libros/categoria/{id}")
    Call<ObtenerLibrosPorCategoriaData> ObtenerLibrosPorCategoria(@Path("id") int id);
//
//      @POST("/login")
//      Call<ApiResponse> login(@Body LoginParams loginParams);

        /* @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);*/

      // Call<MyData> getDataUser(@Query("ACTION") String action);
      /*@GET("MyServlet")
        Call<MyData> getDataUser(@Query("ACTION") String action,
                                 @Query("EMAIL") String email,
                                 @Query("PASSWORD") String pass);
*/
/*      @GET("MyServlet")
        Call<ArrayList<Movie>> getMovies(@Query("genre") String genre,
                                    @Query("year") Integer year,
                                    @Query("director") String director);
      }*/
//
//        @GET("MyServlet")
//        Call<DataMovies> getDataMovies(@Query("ACTION") String action);
//
//        @GET("MyServlet")
//        Call<DataMovies> getDataMovies2(@Query("ACTION") String action);

        /*
        @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);

        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);*/

        /*
        @FormUrlEncoded
          @POST("/login")
          Call<ApiResponse> login(@Field("username") String username,
          @Field("password") String password);
    */



}
