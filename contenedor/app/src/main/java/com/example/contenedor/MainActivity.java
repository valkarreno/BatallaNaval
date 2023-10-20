package com.example.contenedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String [] opciones = {"Sumar" , "Restar" , "Multiplicar" , "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
    }
}

