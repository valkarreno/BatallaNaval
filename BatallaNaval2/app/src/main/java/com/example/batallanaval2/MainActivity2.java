package com.example.batallanaval2;

public class MainActivity2 extends AppCompatActivity {

    private EditText jugador2NombreEditText;
    private Button iniciarJuegoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        jugador2NombreEditText = findViewById(R.id.jugador2NombreEditText);
        iniciarJuegoButton = findViewById(R.id.iniciarJuegoButton);

        final String nombreJugador1 = getIntent().getStringExtra("nombreJugador1");

        iniciarJuegoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreJugador2 = jugador2NombreEditText.getText().toString();

                // Ahora puedes iniciar el juego con los nombres de los dos jugadores
            }
        });
    }
}
