package com.example.fakeflix;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter {
    public class PeliculasViewHolder extends RecyclerView.ViewHolder{

        private TextView titleFilm;
        private TextView infoFilm;
        private ImageView imgFilm;

        public PeliculasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
