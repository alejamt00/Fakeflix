package com.example.fakeflix;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/*
    Clase Pelicula
    Es la encargada de la información de cada uno de los tipo Pelicula usados en esta actividad
    (Cada elemento de la lista de peliculas es un objeto Pelicula)
 */
public class Pelicula {

    //Variables principales de los objetos Pelicula
    private String nombre;
    private String info;
    private int idPortada;
    private String urlTrailer;

    /*
        Constructor parametrizado con el nombre, información relativa, id del resource de la caratula
        y url del trailer de una pelicula concreta.
     */
    public Pelicula(String nombre, String info, int idPortada, String urlTrailer) {
        this.nombre = nombre;
        this.info = info;
        this.idPortada = idPortada;
        this.urlTrailer = urlTrailer;
    }

    // Setters y getters de la clase.
    public String getNombre() {
        return nombre;
    }

    public String getInfo() {
        return info;
    }

    public int getidPortada() {
        return idPortada;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInfo(String info) {
        this.info = info;

    }

    public void setIdPortada(int idPortada) {
        this.idPortada = idPortada;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
}
