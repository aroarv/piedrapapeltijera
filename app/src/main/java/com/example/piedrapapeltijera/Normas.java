package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Normas extends AppCompatActivity {

    private Button botonVolver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normas);

        botonVolver=(Button)findViewById(R.id.botonVolver);

        //boton para volver al inicio
        botonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Normas.this,"Volviendo al inicio",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        //El texto con las normas y demás las escribí en el xml, pero se podría realizar también con un setText
    }
}
