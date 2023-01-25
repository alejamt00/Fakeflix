package com.example.fakeflix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<Pelicula> listaPeliculas;
    private LayoutInflater lInflater;
    private Context context;


    public RecyclerAdapter(ArrayList<Pelicula> listaPeliculas, Context context){
        this.lInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaPeliculas = listaPeliculas;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.recycler_film_row,null);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.bindData(listaPeliculas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleFilm;
        private TextView infoFilm;
        private ImageView imgFilm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleFilm = itemView.findViewById(R.id.tituloPeliculaRow);
            infoFilm = itemView.findViewById(R.id.infoPeliculaRow);
            imgFilm = itemView.findViewById(R.id.ivPeliculaItem);
        }

        public void bindData(Pelicula p){
            titleFilm.setText(p.getNombre());
            infoFilm.setText(p.getInfo());
            imgFilm.setImageResource(p.getidPortada());
        }
    }

}