package com.example.batallanaval;

import android.content.DialogInterface;
import android.content.Intent;
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

    private GridLayout gridLayoutBoard;
    private Button[][] buttons = new Button[10][10];
    private int[][] board = new int[10][10];
    private int shipsRemaining = 15;
    private int totalShots = 0;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayoutBoard = findViewById(R.id.gridLayoutBoard);
        textViewMessage = findViewById(R.id.textViewMessage);

        initializeBoard();
        placeShips();

        int buttonSizeInDp = 39; // Tamaño de los botones en dp
        int buttonSizeInPixels = (int) (buttonSizeInDp * getResources().getDisplayMetrics().density);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setLayoutParams(new GridLayout.LayoutParams());
                buttons[i][j].getLayoutParams().width = buttonSizeInPixels;
                buttons[i][j].getLayoutParams().height = buttonSizeInPixels;
                buttons[i][j].setText("");
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button button = (Button) view;
                        int row = Integer.parseInt(button.getTag().toString()) / 10;
                        int col = Integer.parseInt(button.getTag().toString()) % 10;
                        handleShot(row, col, button);
                    }
                });
                buttons[i][j].setTag(i * 10 + j);
                gridLayoutBoard.addView(buttons[i][j]);
            }
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0; // Agua
            }
        }
    }

    private void placeShips() {
        Random random = new Random();
        int shipsPlaced = 0;

        while (shipsPlaced < 5) {
            int tipo = shipsPlaced + 1; // Tipos de barcos: 1, 2, 3, 4, 5
            int longitud = tipo; // Longitud del barco según el tipo
            List<Integer> posiciones = new ArrayList<>();

            // Generar una posición aleatoria para el barco
            int row = random.nextInt(10);
            int col = random.nextInt(10);

            // Verificar si el barco cabe en esa posición
            boolean puedeColocar = true;
            for (int i = 0; i < longitud; i++) {
                if (row + i >= 10 || board[row + i][col] != 0) {
                    puedeColocar = false;
                    break;
                }
            }

            // Si el barco cabe en la posición, se coloca
            if (puedeColocar) {
                for (int i = 0; i < longitud; i++) {
                    board[row + i][col] = 1; // Marcar el tablero con el barco
                    posiciones.add((row + i) * 10 + col);
                }
                shipsPlaced++;
                //barcos.add(new Barco(tipo, posiciones));
            }
        }
    }


    private void handleShot(int row, int col, Button button) {
        if (board[row][col] == 1) {
            button.setBackgroundResource(R.drawable.explosion); // Barco hundido
            button.setEnabled(false);
            shipsRemaining--;
            // tiro acertado
            textViewMessage.setText("¡Barco hundido!");

        } else if (board[row][col] == 0) {
            button.setBackgroundResource(R.drawable.agua);
            button.setEnabled(false);
            // tiro fallido
            textViewMessage.setText("¡Agua!");
        }

        totalShots++;

        if (shipsRemaining == 0) {
            // Muestra un mensaje de victoria usando un AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("¡Ganaste!");
            builder.setMessage("Hundiste todos los barcos en " + totalShots + " disparos.");

            // Agrega un botón para reiniciar el juego
            builder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Coloca aquí la lógica para reiniciar el juego
                    reiniciarJuego();
                }
            });

            // Agrega un botón para ir al inicio (menu)
            builder.setNeutralButton("Inicio", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }

    private void reiniciarJuego() {
        // Coloca aquí la lógica para reiniciar el juego
        // Puedes reiniciar el tablero, los barcos, los contadores y cualquier otra variable relevante
        initializeBoard();
        placeShips();
        shipsRemaining = 15;
        totalShots = 0;
        // También puedes restablecer la apariencia de los botones en el GridLayout si es necesario.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setBackgroundResource(android.R.drawable.btn_default); // Restablece la apariencia
                buttons[i][j].setEnabled(true); // Habilita los botones
                buttons[i][j].setText(""); // Borra cualquier texto en los botones
            }
        }
        textViewMessage.setText(""); // Borra el mensaje de la vista
    }

}





