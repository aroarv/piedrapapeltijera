package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class Jugar extends AppCompatActivity {
    //elementos pantalla usuario
    private ImageView imagenTijera;
    private ImageView imagenPiedra;
    private ImageView imagenPapel;
    private ImageView imagenLagarto;
    private ImageView imagenSpock;
    private ImageView imagenJugador;
    private ImageView imagenConsola;
    private TextView labelContador2;
    private Button botonVolver;

    int contadorjug=0;
    int contadorcons=0;
    private String eljug;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        imagenTijera=(ImageView)findViewById(R.id.imagenTijera);
        imagenPiedra=(ImageView)findViewById(R.id.imagenPiedra);
        imagenPapel=(ImageView)findViewById(R.id.imagenPapel);
        imagenLagarto=(ImageView)findViewById(R.id.imagenLagarto);
        imagenSpock=(ImageView)findViewById(R.id.imagenSpock);
        imagenJugador=(ImageView)findViewById(R.id.imagenJugador);
        imagenConsola=(ImageView)findViewById(R.id.imagenConsola);
        labelContador2=(TextView)findViewById(R.id.labelContador2);
        botonVolver=(Button)findViewById(R.id.botonVolver);

        //Acciones que realiza cada imagen al clickear en ellas
        imagenTijera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Ponemos donde la elección del jugador la imagen del elemento elegido.
                imagenJugador.setImageResource(R.mipmap.tijera);
                //le damos a la imagen un valor para el juego
                juego("Tijera");
            }
        });
        imagenPiedra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imagenJugador.setImageResource(R.mipmap.piedra);
                juego("Piedra");
            }
        });
        imagenPapel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imagenJugador.setImageResource(R.mipmap.papel);
                juego("Papel");
            }
        });
        imagenLagarto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imagenJugador.setImageResource(R.mipmap.lagarto);
                juego("Lagarto");
            }
        });
        imagenSpock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imagenJugador.setImageResource(R.mipmap.spock);
                juego("Spock");
            }
        });
        juego(eljug);
    }

    public void juego(String eljug) {
        //Elección consola aleatoria
        Random r = new Random();
        int decisionconsola = r.nextInt(5) + 1; //aleatorio
        String decisionconsola2 = "";
        if (decisionconsola == 1) {
            decisionconsola2 = "Papel";
        } else if (decisionconsola == 2) {
            decisionconsola2 = "Piedra";
        } else if (decisionconsola == 3) {
            decisionconsola2 = "Tijera";
        } else if (decisionconsola == 4) {
            decisionconsola2 = "Lagarto";
        } else if (decisionconsola == 5) {
            decisionconsola2 = "Spock";
        }
        //para poner una imagen con la elección de la consola
        if (decisionconsola2 == "Papel") {
            imagenConsola.setImageResource(R.mipmap.papel);
        } else if (decisionconsola2 == "Piedra") {
            imagenConsola.setImageResource(R.mipmap.piedra);
        } else if (decisionconsola2 == "Tijera") {
            imagenConsola.setImageResource(R.mipmap.tijera);
        } else if (decisionconsola2 == "Lagarto") {
            imagenConsola.setImageResource(R.mipmap.lagarto);
        } else if (decisionconsola2 == "Spock") {
            imagenConsola.setImageResource(R.mipmap.spock);
        } else {
            imagenConsola.setImageResource(R.mipmap.gato);
        }
        //EL JUEGO
        if (eljug==decisionconsola2) { //EMPATE
            Toast.makeText(Jugar.this,"Empate",Toast.LENGTH_SHORT).show();
            //Si escoges papel
        } else if (eljug=="Papel"&&decisionconsola2=="Piedra") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! El papel tapa a la piedra",Toast.LENGTH_SHORT).show();
            //Se suma al jugador un punto en el contador y a la consola se le pone en 0.
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if (eljug=="Papel"&&decisionconsola2=="Lagarto") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! El papel es devorado por el lagarto",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if (eljug=="Papel"&&decisionconsola2=="Tijera") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! El papel es cortado por la tijera",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if (eljug=="Papel"&&decisionconsola2=="Spock") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! El papel desautoriza a Spock",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
            //si escoges piedra
        } else if(eljug=="Piedra"&&decisionconsola2=="Lagarto") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! La piedra aplasta al lagarto",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if(eljug=="Piedra"&&decisionconsola2=="Tijera") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! La piedra aplasta a la tijera",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if(eljug=="Piedra"&&decisionconsola2=="Papel") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! La piedra es tapada por el papel",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }  else if(eljug=="Piedra"&&decisionconsola2=="Spock") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! La piedra es vaporizada por Spock",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
            //Si eliges tijera
        } else if (eljug=="Tijera"&&decisionconsola2=="Piedra") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! La tijera es aplastada por la piedra",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }else if (eljug=="Tijera"&&decisionconsola2=="Lagarto") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! La tijera decapita al lagarto",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        } else if (eljug=="Tijera"&&decisionconsola2=="Papel") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! La tijera corta al papel",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }else if (eljug=="Tijera"&&decisionconsola2=="Spock") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! La tijera está rota por Spock",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
            //Si eliges lagarto
        } else if (eljug=="Lagarto"&&decisionconsola2=="Piedra") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! El lagarto es aplastado por le piedra",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }  else if (eljug=="Lagarto"&&decisionconsola2=="Tijera") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! El lagarto es decapitado por la tijera",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }  else if (eljug=="Lagarto"&&decisionconsola2=="Papel") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! El lagarto devora al papel",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }   else if (eljug=="Lagarto"&&decisionconsola2=="Spock") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! El lagarto envenena a Spock",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
            //Si eliges Spock
        }else if (eljug=="Spock"&&decisionconsola2=="Lagarto") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! Spock es envenenado por el lagarto",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }else if (eljug=="Spock"&&decisionconsola2=="Piedra") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! Spock vaporiza a la piedra",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }else if (eljug=="Spock"&&decisionconsola2=="Tijera") { //GANAS
            Toast.makeText(Jugar.this,"¡Has ganado! Spock rompe la tijera",Toast.LENGTH_SHORT).show();
            contadorjug++;
            contadorcons=0;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }else if (eljug=="Spock"&&decisionconsola2=="Papel") { //PIERDES
            Toast.makeText(Jugar.this,"¡Has perdido! Spock es desautorizado por el papel",Toast.LENGTH_SHORT).show();
            contadorjug=0;
            contadorcons++;
            labelContador2.setText("           Jugador "+Integer.toString(contadorjug)+"                                   Consola "+Integer.toString(contadorcons));
        }

        //SQLite, guardar victorias consecutivas máximas

        //boton para volver al inicio
        botonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Volvemos a la pagina principal
                Toast.makeText(Jugar.this,"Volviendo al inicio",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
