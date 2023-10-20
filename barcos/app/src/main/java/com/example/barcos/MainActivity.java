package com.example.barcos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Crea una lista de objetos CardItem
        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem("Tarjeta 1"));
        cardItemList.add(new CardItem("Tarjeta 2"));
        // Agrega más elementos si es necesario

        // 2. Encuentra el RecyclerView en tu diseño
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // 3. Crea un LinearLayoutManager para organizar las tarjetas en una lista vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 4. Crea una instancia del adaptador personalizado y pásale la lista de datos
        MyAdapter adapter = new MyAdapter(cardItemList, this);

        // 5. Asigna el adaptador al RecyclerView
        recyclerView.setAdapter(adapter);
    }
}
