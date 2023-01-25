package com.example.fakeflix;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Pelicula {
    private String nombre;
    private String info;
    private int idPortada;
    private String urlTrailer;

    public Pelicula(String nombre, String info, int idPortada, String urlTrailer) {
        this.nombre = nombre;
        this.info = info;
        this.idPortada = idPortada;
        this.urlTrailer = urlTrailer;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInfo() { return info; }

    public int getidPortada() {
        return idPortada;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInfo(String info) { this.info = info; }

    public void setIdPortada(int idPortada) {
        this.idPortada = idPortada;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
