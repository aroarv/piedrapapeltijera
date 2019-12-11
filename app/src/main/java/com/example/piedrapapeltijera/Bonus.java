package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Bonus extends AppCompatActivity {
    private Button botonVolver;
    private VideoView videoBonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        botonVolver=(Button)findViewById(R.id.botonVolver);
        videoBonus=(VideoView)findViewById(R.id.videoBonus);

        //En manifest damos permiso de internet para poder reproducir el video
        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        //La siguiente linea de código hace que aparezca en la parte inferior de la aplicación controles para poder parar, acelerar y retroceder el video
        videoBonus.setMediaController(new MediaController(this));
        videoBonus.setVideoURI(uri);
        videoBonus.requestFocus();
        //Inicia el video
        videoBonus.start();

        //boton para volver al inicio
        botonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Bonus.this,"Volviendo al inicio",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
