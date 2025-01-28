package com.example.loginandroid_29_09_2023.lstMov.presenter;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Libros;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.model.LstMoviesModel;

import java.util.ArrayList;
import java.util.List;

public class LstMoviesPresenter implements ContractListMovies.Presenter,ContractListMovies.Model.LibrosPorCategoriaListener,ContractListMovies.Model.CategoriasListener,ContractListMovies.Model.LibrosListener{

    private ContractListMovies.View vista;
    private LstMoviesModel lstMoviesModel;

    public LstMoviesPresenter(ContractListMovies.View vista){
        this.vista = vista;
        lstMoviesModel = new LstMoviesModel(this);
    }

    @Override
    public void onSuccessCategoriasListener(List<Categoria> categorias) {
        vista.onSuccesObtenerCategorias(categorias);
    }

    @Override
    public void onFailureCategoriasListener(String message) {
        onFailureCategoriasListener(message);
    }

    @Override
    public void onSuccessLibrosListener(List<Libros> libros) {
        vista.onSuccesObtenerLibros(libros);
    }

    @Override
    public void onFailureLibrosListener(String message) {
        onFailureLibrosListener(message);
    }

    @Override
    public void onSuccessLibrosPorCategoriaListener(List<Libros> libros) {
        vista.onSuccesObtenerLibrosPorCategoria(libros);
    }

    @Override
    public void onFailureLibrosPorCategoriaListener(String message) {
        onFailureLibrosPorCategoriaListener(message);
    }

    @Override
    public void obtenerLibros() {
        lstMoviesModel.obtenerLibrosApi(this);
    }

    @Override
    public void obtenerCategorias() {
        lstMoviesModel.obtenerCategoriasApi(this);
    }

    @Override
    public void obtenerLibrosPorCategoria(int categoria) {
        lstMoviesModel.obtenerLibrosPorCategoriaApi(categoria,this);
    }

}
