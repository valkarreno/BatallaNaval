package com.example.navalbattle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int numRows = 10;
    private int numCols = 10;
    private int[][] gameBoard = new int[numRows][numCols];
    private boolean gameWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        Button resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Button button = new Button(this);
                button.setLayoutParams(new GridLayout.LayoutParams());
                button.setTag(row * numCols + col);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!gameWon) {
                            onCellClick((int) view.getTag());
                        }
                    }
                });
                gridLayout.addView(button);
            }
        }

        resetGame();
    }

    private void resetGame() {
        gameWon = false;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                gameBoard[row][col] = 0;
                Button button = (Button) findViewById(row * numCols + col);
                button.setText("");
                button.setEnabled(true);
            }
        }
        findViewById(R.id.resetButton).setVisibility(View.GONE);
    }

    private void onCellClick(int cellIndex) {
        int row = cellIndex / numCols;
        int col = cellIndex % numCols;

        // Implement your game logic here
        // For simplicity, let's assume a ship is located at (2,2)
        if (row == 2 && col == 2) {
            gameBoard[row][col] = 1; // Mark as a hit
            Button button = (Button) findViewById(cellIndex);
            button.setText("O"); // Display "O" for a hit
            checkGameStatus();
        } else {
            gameBoard[row][col] = -1; // Mark as a miss
            Button button = (Button) findViewById(cellIndex);
            button.setText("X"); // Display "X" for a miss
        }
        findViewById(R.id.resetButton).setVisibility(View.VISIBLE);
    }

    private void checkGameStatus() {
        // Implement your game over logic here
        // For simplicity, we'll just check if all hits have been made
        boolean allHitsMade = true;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (gameBoard[row][col] == 0) {
                    allHitsMade = false;
                    break;
                }
            }
        }
        if (allHitsMade) {
            gameWon = true;
            Toast.makeText(this, "Congratulations! You won!", Toast.LENGTH_SHORT).show();
        }
    }
}
