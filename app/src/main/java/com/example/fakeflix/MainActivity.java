package com.example.fakeflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

/*
   Clase MainActivity
   Clase de la ventana principal, el oncreate solo setea su layout, el cual incluye un fragmentcontainer
   con un fragmente seteado por xml.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para ocultar barra superior
        getSupportActionBar().hide();

    }
}