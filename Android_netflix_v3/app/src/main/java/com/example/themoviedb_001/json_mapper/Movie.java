package com.example.themoviedb_001.json_mapper;

public class Movie {
    private int id;
    private String title;
    private String overview;
    private String poster_path;
    private String release_date;
    private double vote_average; // Nuevo campo para el promedio de votos
    private double popularity; // Nuevo campo para la popularidad


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date; // Método setter para la fecha de lanzamiento
    }
    public String getRelease_date() {
        return release_date; // Método getter para la fecha de lanzamiento
    }
    public double getVote_average() {
        return vote_average; // Método getter para el promedio de votos
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average; // Método setter para el promedio de votos
    }

    public double getPopularity() {
        return popularity; // Método getter para la popularidad
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity; // Método setter para la popularidad
    }
}
