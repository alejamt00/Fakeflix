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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<Pelicula> listaPeliculas;
    private LayoutInflater lInflater;
    private Context context;
    private FragmentTransaction ft;
    private ArrayList<Pelicula> listaOriginal;



    public RecyclerAdapter(ArrayList<Pelicula> listaPeliculas, Context context, FragmentTransaction ft){
        this.lInflater = LayoutInflater.from(context);
        this.listaPeliculas = listaPeliculas;
        this.listaOriginal = new ArrayList<Pelicula>();
        this.listaOriginal.addAll(listaPeliculas);
        this.ft = ft;
    }

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

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.recycler_film_row,null);
        return new RecyclerAdapter.ViewHolder(view);
    }

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