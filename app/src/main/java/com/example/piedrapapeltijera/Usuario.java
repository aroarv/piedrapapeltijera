package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {
    //elementos pantalla usuario
    private Button botonNombre;
    private Button botonVolver;
    private EditText textBoxNombre;

    private String nombre;

    //para guardar el nombre de usuario
    private SharedPreferences.Editor editorPreferencias;
    private SharedPreferences preferencias;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        botonNombre=(Button)findViewById(R.id.botonNombre);
        botonVolver=(Button)findViewById(R.id.botonVolver);
        textBoxNombre=(EditText)findViewById(R.id.textBoxNombre);

        //Objeto preferencias
        final SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        botonNombre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Editor
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("nombre",textBoxNombre.getText().toString());
                //con commit guardamos los datos
                editor.commit();
                Toast.makeText(Usuario.this,"Usuario guardado correctamente",Toast.LENGTH_SHORT).show();
            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Volvemos a la pagina principal
                Toast.makeText(Usuario.this,"Volviendo al inicio",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
