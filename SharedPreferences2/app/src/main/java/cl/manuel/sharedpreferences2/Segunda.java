package cl.manuel.sharedpreferences2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Segunda extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Aquí se cargan los datos enviados por MainActivity en un archivo SP

        TextView tv = findViewById(R.id.tv2);

        String archivo = getPackageName() + "archivoSP";
        SharedPreferences sp = getSharedPreferences(archivo, Context.MODE_PRIVATE); //Recuperación de archivo ya creado

        String nombre = sp.getString("nombre", "nombre"); //Recuperación de datos de archivo SP
        String apellido = sp.getString("apellido", "apellido");

        tv.setText(String.format("%s %s", nombre, apellido)); //Mostrar datos
    }
}
