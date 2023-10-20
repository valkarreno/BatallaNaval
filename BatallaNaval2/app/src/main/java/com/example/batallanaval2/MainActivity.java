package com.example.batallanaval2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText jugador1NombreEditText;
    private Button siguienteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno);

        jugador1NombreEditText = findViewById(R.id.jugador1NombreEditText);
        siguienteButton = findViewById(R.id.siguienteButton);

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreJugador1 = jugador1NombreEditText.getText().toString();

                Intent intent = new Intent(ActivityUno.this, ActivityDos.class);
                intent.putExtra("nombreJugador1", nombreJugador1);
                startActivity(intent);
            }
        });
    }
}
