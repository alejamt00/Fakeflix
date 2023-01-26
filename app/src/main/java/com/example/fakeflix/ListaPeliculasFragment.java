package com.example.fakeflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPeliculasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPeliculasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Pelicula> listaPeliculas;
    private RecyclerView recyclerPeliculas;

    public ListaPeliculasFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPeliculasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPeliculasFragment newInstance(String param1, String param2) {
        ListaPeliculasFragment fragment = new ListaPeliculasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);


        listaPeliculas = new ArrayList<Pelicula>();

        recyclerPeliculas = (RecyclerView) view.findViewById(R.id.recyclerViewListaPeliculas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerPeliculas.setLayoutManager(linearLayoutManager);


        Pelicula p1 = new Pelicula("El Señor de los Anillos","Disfruta de la trilogía original de \"El señor de los anillos\" de Peter Jackson.",R.drawable.lotr , "https://www.youtube.com/embed/3GJp6p_mgPo");
        listaPeliculas.add(p1);
        Pelicula p2 = new Pelicula("Killer Bean", "Se desarrolla en un mundo de granos de café, concretamente de uno llamado Jack Bean.", R.drawable.killer_bean,"https://www.youtube.com/embed/n4_7-lYjLEI");
        listaPeliculas.add(p2);
        Pelicula p3 = new Pelicula("Jagger Royale", "Todos los personajes míticos de Mister Jägger se enfrentarán en un combate a muerte. Sólo puede quedar uno.", R.drawable.jagger_royale,"https://www.youtube.com/embed/n-vf235dvtc");
        listaPeliculas.add(p3);
        Pelicula p4 = new Pelicula("Minions: The Rise of Gru", "Pélicula precuela de la famosa saga \"Gru mi villano favorito\".",R.drawable.minions, "https://www.youtube.com/embed/EgXQmSW16YY");
        listaPeliculas.add(p4);
        Pelicula p5 = new Pelicula("Feel Good Man", "Documental de la famosa rana meme llamada \"Pepe\".",R.drawable.pepelore,"https://www.youtube.com/embed/AAPdP5JVrzs");
        listaPeliculas.add(p5);
        Pelicula p6 = new Pelicula("Operación ISAM", "Película-documental de los hechos acontecidos entre IlloJuan, LMDShow y \"El novio de Masi\".",R.drawable.op_isam,"https://www.veed.io/embed/fb42bf26-68ea-4d79-8f78-f8cf671f5f3f");
        listaPeliculas.add(p6);
        Pelicula p7 = new Pelicula("14 Días: Never Zurrender", "Tras los hechos acotencidos en la Operación ISAM, se desató una guerra viral zombie. Solo quedan 14 días antes del fin.",R.drawable.catorce_dias,"https://www.youtube.com/embed/Its355mzxJo");
        listaPeliculas.add(p7);



        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(listaPeliculas,getContext(), ft);
        recyclerPeliculas.setAdapter(recyclerAdapter);

        return view;

    }
}
