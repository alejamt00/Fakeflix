package com.example.fakeflix;

import android.widget.ImageView;

public class Pelicula {
    private String nombre;
    private String info;
    private ImageView ivPelicula;
    private String urlTrailer;

    public Pelicula(String nombre, ImageView ivPelicula, String urlTrailer) {
        this.nombre = nombre;
        this.ivPelicula = ivPelicula;
        this.urlTrailer = urlTrailer;
    }

    public String getNombre() {
        return nombre;
    }

    public ImageView getIvPelicula() {
        return ivPelicula;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIvPelicula(ImageView ivPelicula) {
        this.ivPelicula = ivPelicula;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
