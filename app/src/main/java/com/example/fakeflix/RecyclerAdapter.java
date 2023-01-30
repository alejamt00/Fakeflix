package com.example.fakeflix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
    Clase RecyclerAdapter
    Necesaria para el comportamiento y contenido de la lista de peliculas, buscador, comportamiento
    a la hora de clickar en una pelicula concreta...
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    // Variables necesarias de la clase
    private ArrayList<Pelicula> listaPeliculas;
    private LayoutInflater lInflater;
    private FragmentTransaction ft;

    //Copia de la listaPeliculas completa, usada en el buscador para no perder información
    private ArrayList<Pelicula> listaOriginal;



    /*
        Constructor parametrizado que inicializa y obtiene el Fragment Transaction de la clase
        ListaPeliculasFragment utilizado más abajo, el contexto para inflar el layout y la listaPeliculas
        que es rellenada en la clase ListaPeliculasFragment y utilizada aqui para setear cada
        elemento del recycler
     */
    public RecyclerAdapter(ArrayList<Pelicula> listaPeliculas, Context context, FragmentTransaction ft){
        this.lInflater = LayoutInflater.from(context);
        this.listaPeliculas = listaPeliculas;
        this.listaOriginal = new ArrayList<Pelicula>();
        this.listaOriginal.addAll(listaPeliculas);
        this.ft = ft;
    }

    /*
        Método usado para el searchview, permite setear la lista de peliculas usando de filtro lo
        introducido en el campo de búsqueda y cambiar la lista que se muestra.
     */
    public void filtro(String txt){
        if(txt.length()==0){
            listaPeliculas.clear();
            listaPeliculas.addAll(listaOriginal);
        } else {
            listaPeliculas.clear();
            for (Pelicula p: listaOriginal) {
                if (p.getNombre().toLowerCase().contains(txt.toLowerCase())){
                    listaPeliculas.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    /*
        Método llamado cuando el RecyclerView necesita un nuevo viewholder del tipo dado para representar
        un item de la lista, que "infla" cada elemento o row con su layaout.
     */
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.recycler_film_row,null);
        return new RecyclerAdapter.ViewHolder(view);
    }

    /*
        Método que setea la información de cada item de la lista a cada row del recycler segun la
        "position" actual.
        También implementa el onclicklistener del holder entero, para ver los detalles de la película
        seleccionada.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(listaPeliculas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetallesPelicula dp = new DetallesPelicula(listaPeliculas.get(position).getNombre(),listaPeliculas.get(position).getInfo(),listaPeliculas.get(position).getUrlTrailer());
                ft.replace(R.id.fragmentContainerView,dp).commit();
                ft.addToBackStack(null);
            }
        });
    }

    /*
        Método que devuelva el tamaño de la lista de peliculas
     */
    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    /*
        Clase ViewHolder, encargada de setear los textos e imagenes de cada row
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleFilm;
        private TextView infoFilm;
        private ImageView imgFilm;

        /*
            Constructor que "engancha" las variables a las del layout
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleFilm = itemView.findViewById(R.id.tituloPeliculaRow);
            infoFilm = itemView.findViewById(R.id.infoPeliculaRow);
            imgFilm = itemView.findViewById(R.id.ivPeliculaItem);
        }

        /*
            Setea los textos según la Pelicula p dada, llamado en el onBindViewHolder para setear la info
            segun posicion.
         */
        public void bindData(Pelicula p){
            titleFilm.setText(p.getNombre());
            infoFilm.setText(p.getInfo());
            imgFilm.setImageResource(p.getidPortada());
        }
    }

}