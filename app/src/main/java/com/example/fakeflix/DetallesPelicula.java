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
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallesPelicula#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallesPelicula extends Fragment {

    private String nom;
    private String info;
    private String trailer;

    public DetallesPelicula(String nom, String info, String trailer) {
        this.nom = nom;
        this.info = info;
        this.trailer = trailer;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetallesPelicula.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallesPelicula newInstance(String nom, String info, String trailer) {
        DetallesPelicula fragment = new DetallesPelicula(nom,info,trailer);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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