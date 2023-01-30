package com.example.fakeflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifImageView;

/**
 * Clase DetallesPelicula
 * Fragmento que se lanza al hacer click a una película de la lista en el otro fragmento (ListaPeliculasFragment)
 * que muestra su información y trailer.
 */
public class DetallesPelicula extends Fragment {

    private String nom;
    private String info;
    private String trailer;

    /*
        Constructor de clase parametrizado con la info de la peli seleccionada.
     */
    public DetallesPelicula(String nom, String info, String trailer) {
        this.nom = nom;
        this.info = info;
        this.trailer = trailer;
    }

    /*
        Constructor de clase que llama al anterior, no utlizado en este caso pero sería funcional,
        simplemente llama al constructor parametrizado.
     */
    public static DetallesPelicula newInstance(String nom, String info, String trailer) {
        DetallesPelicula fragment = new DetallesPelicula(nom,info,trailer);

        return fragment;
    }

    /*
        Método llamado al crearse el fragmento.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /*
        Método llamado tras el onCreate.
        Infla el layout del fragmento, vincula variables con su id de resource y sete textos variables
        pasadas por el constructor (nombre, informacion y link de trailer)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles_pelicula, container, false);

        TextView tvNombre = view.findViewById(R.id.tvTitle);
        TextView tvInfo = view.findViewById(R.id.tvInfo);
        WebView wvTrailer = view.findViewById(R.id.trailerWebView);
        GifImageView gif = view.findViewById(R.id.loadGif);


        tvNombre.setText(nom);
        tvInfo.setText(info);
        wvTrailer.getSettings().setJavaScriptEnabled(true);
        wvTrailer.loadUrl(trailer);
        wvTrailer.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                gif.setVisibility(View.INVISIBLE);
                wvTrailer.setVisibility(View.VISIBLE);
            }
        });


        return view;
    }
}