package com.example.fakeflix;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase ListaPeliculasFragment
 * Fragmento mostrado en el mainactivity inicialmente que muestra la lista de películas gracias al
 * recycler adapter.
 */
public class ListaPeliculasFragment extends Fragment {

    private ArrayList<Pelicula> listaPeliculas;
    private RecyclerView recyclerPeliculas;
    private RecyclerAdapter recyclerAdapter;

    private SearchView sv;

    /*
        Constructor de clase vacío, no utilizado ya que seteo este fragmento a un fragment container
        del main activity via XML.
     */
    public ListaPeliculasFragment() {

    }

    /*
        Constructor que llama al unico constructor de la clase, vacío en este caso.
    */
    public static ListaPeliculasFragment newInstance() {
        ListaPeliculasFragment fragment = new ListaPeliculasFragment();
        return fragment;
    }

    // Método llamado cuando se "crea" el fragmento, ejecutado antes del onCreateView.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /*
        Al haber "abierto" el fragmento mediante xml, este método, que se ejecuta tras el onCreate,
        funciona a modo de constructor.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);


        listaPeliculas = new ArrayList<Pelicula>();

        recyclerPeliculas = (RecyclerView) view.findViewById(R.id.recyclerViewListaPeliculas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerPeliculas.setLayoutManager(linearLayoutManager);


        /*
            Películas creadas y añadidas a la lista de películas, con toda la información necesaria:
                Nombre
                Info
                Portada
                URL del trailer
         */
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
        // Referencias a anteriores trabajos.
        Pelicula p9 = new Pelicula("M̷̡̞̮̺͔̭͓͊͑͂̂̊ͅͅa̴͕͗̽́̋̇͠͝ț̶̰͔̝͒͗͗͘͠r̴̟͈̞͗̈́́̌́̈i̶̢̱̼̖͎̜̜͋̍̈́͒̅̅̎̅͘x̵͙̰̫͖̥̱͑̕͝","?x?????i???????r????t????a????m????????????",R.drawable.matrix,"https://rezmason.github.io/matrix/");
        listaPeliculas.add(p9);
        Pelicula p8 = new Pelicula("Project Penguin", "4 pingüinos están preparados para cualquier cosa con tal de salvar el mundo.", R.drawable.penguin,"https://www.youtube.com/embed/snOpRK4MNc4");
        listaPeliculas.add(p8);

        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        recyclerAdapter = new RecyclerAdapter(listaPeliculas,getContext(), ft);
        recyclerPeliculas.setAdapter(recyclerAdapter);

        sv = view.findViewById(R.id.searchView);
        sv.setIconifiedByDefault(false);
        sv.clearFocus();

        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) sv.findViewById(id);
        textView.setTextColor(Color.RED);

        /*
            Método listener para que funcione el buscador que llama al método "filtro(string)",
            implementado en el recycler adapter.
         */
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                recyclerAdapter.filtro(s);
                return false;
            }
        });



        return view;

    }
}
