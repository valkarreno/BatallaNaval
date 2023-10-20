package com.example.barcos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<CardItem> cardItems;
    private Context context;

    // Constructor del adaptador
    public MyAdapter(List<CardItem> cardItems, Context context) {
        this.cardItems = cardItems;
        this.context = context;
    }

    // Método para inflar el diseño de la tarjeta
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    // Método para asignar datos a las vistas de la tarjeta
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardItem cardItem = cardItems.get(position);

        if (position == 0) {
            holder.button1.setVisibility(View.VISIBLE);
            holder.button2.setVisibility(View.GONE);
        } else if (position == 1) {
            holder.button1.setVisibility(View.GONE);
            holder.button2.setVisibility(View.VISIBLE);
        }

        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el "Botón 1" de la primera tarjeta (abrir Activity1)
                Intent intent = new Intent(context, juego.class);
                context.startActivity(intent);
            }
        });

        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el "Botón 2" de la segunda tarjeta (abrir Activity2)
                Intent intent = new Intent(context, reglas.class);
                context.startActivity(intent);
            }
        });
    }



    // Método para obtener la cantidad de elementos en el RecyclerView
    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    // Clase ViewHolder para mantener las vistas de la tarjeta
    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button1, button2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button1 = itemView.findViewById(R.id.button1);
            button2 = itemView.findViewById(R.id.button2);
        }
    }
}
