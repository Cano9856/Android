package com.example.loginandroid_29_09_2023.lstMov.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Libros;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerCategoriasData;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerLibrosData;
import com.example.loginandroid_29_09_2023.lstMov.data.ObtenerLibrosPorCategoriaData;
import com.example.loginandroid_29_09_2023.lstMov.presenter.LstMoviesPresenter;
import com.example.loginandroid_29_09_2023.lstMov.data.DataMovies;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstMoviesModel implements ContractListMovies.Model {
    private static final String IP_BASE = "10.0.0.2:8080";
    private LstMoviesPresenter presenter;

    public LstMoviesModel(LstMoviesPresenter presenter){
        this.presenter = presenter;
    }

//    @Override
//    public void moviesAPI(String filtro,
//                          OnLstMoviesListener respuestaMovies) {
//        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).
//                create(ApiService.class);
//
//        // Call<DataMovies> call = apiService.getDataMovies ("MOVIE.LST_PELICULA");
//        call.enqueue(new Callback<DataMovies>() {
//            @Override
//            public void onResponse(Call<DataMovies> call, Response<DataMovies> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<DataMovies> call, Throwable t) {
//
//            }
//        });
//    }

    @Override
    public void obtenerLibrosApi(LibrosListener listener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<ObtenerLibrosData> call = apiService.ObtenerLibros();
        call.enqueue(new Callback<ObtenerLibrosData>() {
            @Override
            public void onResponse(Call<ObtenerLibrosData> call, Response<ObtenerLibrosData> response) {
                List<Libros> libros = response.body().getLibros();
                listener.onSuccessLibrosListener(libros);
            }

            @Override
            public void onFailure(Call<ObtenerLibrosData> call, Throwable t) {
                listener.onFailureLibrosListener(t.getMessage());
            }
        });
    }

    @Override
    public void obtenerCategoriasApi(CategoriasListener listener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<ObtenerCategoriasData> call = apiService.ObtenerCategorias();
        call.enqueue(new Callback<ObtenerCategoriasData>() {
            @Override
            public void onResponse(Call<ObtenerCategoriasData> call, Response<ObtenerCategoriasData> response) {
                List<Categoria> categorias = response.body().getCategorias();
                listener.onSuccessCategoriasListener(categorias);
            }

            @Override
            public void onFailure(Call<ObtenerCategoriasData> call, Throwable t) {
                listener.onFailureCategoriasListener(t.getMessage());
            }
        });
    }

    @Override
    public void obtenerLibrosPorCategoriaApi(int categoria, LibrosPorCategoriaListener listener) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<ObtenerLibrosPorCategoriaData> call = apiService.ObtenerLibrosPorCategoria(categoria);
        call.enqueue(new Callback<ObtenerLibrosPorCategoriaData>() {
            @Override
            public void onResponse(Call<ObtenerLibrosPorCategoriaData> call, Response<ObtenerLibrosPorCategoriaData> response) {
                List<Libros> libros = response.body().getLibros();
                listener.onSuccessLibrosPorCategoriaListener(libros);
            }

            @Override
            public void onFailure(Call<ObtenerLibrosPorCategoriaData> call, Throwable t) {
                listener.onFailureLibrosPorCategoriaListener(t.getMessage());
            }
        });
    }
}

