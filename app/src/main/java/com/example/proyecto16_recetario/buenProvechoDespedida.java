package com.example.proyecto16_recetario;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//imports de la clase
import android.widget.Button;
import android.view.View;

//import para el audio
import android.media.MediaPlayer;

public class buenProvechoDespedida extends AppCompatActivity {

    //variable de clase de audio
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buen_provecho_despedida);

        //esto es para que el audio se reproduzca al iniciar la activity
        mediaPlayer = MediaPlayer.create(this, R.raw.audiobuenprovecho);
        mediaPlayer.start();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /*Esta función cierra la pantalla final y devuelve a la lista de recetas*/
    /*Un detalle a notar sobre el recorrido de activities, es que idealmente como mejora
    * se podría ir cerrando internamente las activities que inician a otra, pero solo en este caso.
    * Ya que, al llegar al final y presionar este botón, sí, devuelve al intent de la lista, pero
    * internamente las demás activities lanzadas están como en una cola, o sea, si el usuario desde la lista
    * quiere regresar a la de bienvenida, va a tener que pasar por todas las activities por las que recorrió
    * la app*/
    public void regresarALista(View view){
        Intent intent = new Intent(this, listaRecetas.class);
        startActivity(intent);
        finish();
    }
}