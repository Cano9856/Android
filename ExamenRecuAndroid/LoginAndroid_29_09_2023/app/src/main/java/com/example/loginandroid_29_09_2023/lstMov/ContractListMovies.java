package com.example.loginandroid_29_09_2023.lstMov;

import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Libros;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;
import java.util.List;

public interface ContractListMovies {
    interface View{
        void onSuccesObtenerLibros(List<Libros> libros);
        void onFailureObtenerLibros(String message);
        void onSuccesObtenerCategorias(List<Categoria> categorias);
        void onFailureObtenerCategorias(String message);
        void onSuccesObtenerLibrosPorCategoria(List<Libros> libros);
        void onFailureObtenerLibrosPorCategoria(String message);
    }

    interface Presenter{
        void obtenerLibros();
        void obtenerCategorias();
        void obtenerLibrosPorCategoria(int categoria);
    }

    interface Model {
        void obtenerLibrosApi(LibrosListener listener);
        interface LibrosListener{
            void onSuccessLibrosListener(List<Libros> libros);
            void onFailureLibrosListener(String message);
        }
        void obtenerCategoriasApi(CategoriasListener listener);
        interface CategoriasListener{
            void onSuccessCategoriasListener(List<Categoria> categorias);
            void onFailureCategoriasListener(String message);
        }
        void obtenerLibrosPorCategoriaApi(int categoria,LibrosPorCategoriaListener listener);
        interface LibrosPorCategoriaListener{
            void onSuccessLibrosPorCategoriaListener(List<Libros> libros);
            void onFailureLibrosPorCategoriaListener(String message);
        }
    }
}
