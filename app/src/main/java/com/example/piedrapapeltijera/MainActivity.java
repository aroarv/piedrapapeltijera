package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //elementos pantalla principal
    private Button botonUsuario;
    private Button botonJugar;
    private Button botonResultados;
    private Button botonNormas;
    private Button botonBonus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonUsuario=(Button)findViewById(R.id.botonUsuario);
        botonJugar=(Button)findViewById(R.id.botonJugar);
        botonResultados=(Button)findViewById(R.id.botonResultados);
        botonNormas=(Button)findViewById(R.id.botonNormas);
        botonBonus=(Button)findViewById(R.id.botonBonus);

        //botón usuario
         botonUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al clickear en el botón nos vamos a la pantalla de usuario
                Toast.makeText(MainActivity.this,"Accediendo a la pantalla de usuario",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Usuario.class);
                startActivity(intent);
            }
        });

        //botón jugar
        botonJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al clickear en el botón nos vamos a la pantalla para jugar al juego.
                Toast.makeText(MainActivity.this,"Accediendo al juego",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(v.getContext(), Jugar.class);
                startActivity(intent2);
            }
        });

        //botón resultado

        //botón normas
        botonNormas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al clickear en el botón nos vamos a la pantalla con las normas.
                Toast.makeText(MainActivity.this,"Accediendo a las normas",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(v.getContext(), Normas.class);
                startActivity(intent3);
            }
        });

        //botón normas
        botonBonus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Al clickear en el botón nos vamos a la pantalla con el video bonus.
                Toast.makeText(MainActivity.this,"Accediendo al bonus",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(v.getContext(), Bonus.class);
                startActivity(intent4);
            }
        });

    }
}
