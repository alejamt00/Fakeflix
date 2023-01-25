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

        Pelicula p1 = new Pelicula("El señor de los anillos","En verda wanalberto",R.drawable.lotr , "test.com");
        listaPeliculas.add(p1);


        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(listaPeliculas,getContext());
        recyclerPeliculas.setAdapter(recyclerAdapter);

        return view;

    }
}
