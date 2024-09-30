package com.example.themoviedb_001.json_mapper;

import java.util.List;

public class MovieResponse {
    //URL:  https://api.themoviedb.org/3/movie/popular?api_key=174aafe00bb16262f58d20bed7ae0987

    private List<Movie> results;

    // Getters y Setters

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
