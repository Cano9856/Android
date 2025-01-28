package com.example.loginandroid_29_09_2023.lstMov.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Categoria;
import com.example.loginandroid_29_09_2023.beans.Libros;
import com.example.loginandroid_29_09_2023.beans.Producto;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.adapters.PeliculaAdapter;
import com.example.loginandroid_29_09_2023.lstMov.presenter.LstMoviesPresenter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class LstMovies extends AppCompatActivity implements ContractListMovies.View{
    private LstMoviesPresenter lstMoviesPresenter;
    private RecyclerView recyclerView;
    private PeliculaAdapter adapter;
    private Spinner spinnerCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies4);

        initComponents();
    }

    public void initComponents(){
        lstMoviesPresenter = new LstMoviesPresenter(this);
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        spinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    lstMoviesPresenter.obtenerLibros();//obtengo libros
                } else {
                    lstMoviesPresenter.obtenerLibrosPorCategoria(position);//obtengo libros por categoria
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lstMoviesPresenter.obtenerCategorias();//obtengo las categorias
    }

    @Override
    public void onSuccesObtenerLibros(List<Libros> libros) {
        recyclerView = findViewById(R.id.recyclerViewPeliculas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PeliculaAdapter(this, libros);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureObtenerLibros(String message) {

    }

    @Override
    public void onSuccesObtenerCategorias(List<Categoria> categorias) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("");
        for (Categoria categoria:categorias) {
            nombres.add(categoria.getNombre());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(LstMovies.this, android.R.layout.simple_spinner_item, nombres);

        spinnerCategorias.setAdapter(adapter);
    }

    @Override
    public void onFailureObtenerCategorias(String message) {

    }

    @Override
    public void onSuccesObtenerLibrosPorCategoria(List<Libros> libros) {
        adapter = new PeliculaAdapter(this, libros);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailureObtenerLibrosPorCategoria(String message) {

    }


//
//    @Override
//    public void successMovies(ArrayList<Producto> lstPelicula) {
//        // Toast.makeText(this, lstPelicula.get(0).getTitulo(), Toast.LENGTH_SHORT).show();
//        //peliculas = cargarDatos();
//        recyclerView = findViewById(R.id.recyclerViewPeliculas);
//        spinnerCategorias = findViewById(R.id.spinnerCategorias);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter = new PeliculaAdapter(this, lstPelicula);
//        adapter.setOnItemClickListener(new PeliculaAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Producto producto) {
//                // Aquí manejas el clic en la película
//                Toast.makeText(LstMovies.this, producto.getTitulo(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    public void failureMovies(String err) {
//
//    }


}