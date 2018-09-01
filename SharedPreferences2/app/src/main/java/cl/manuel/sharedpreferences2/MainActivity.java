package cl.manuel.sharedpreferences2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Demostración de persistencia de datos con SharedPreferences. Esta vez, el acceso al sp no
    será privado, sino que será accesible desde otra Activty*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnCargar = findViewById(R.id.btnCargar);

        final EditText txtNombre = findViewById(R.id.txtNombre);
        final EditText txtApellido = findViewById(R.id.txtApellido);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String archivo = getPackageName() + "archivoSP"; //Nombre del archivo
                SharedPreferences sp = getSharedPreferences(archivo, Context.MODE_PRIVATE); //Creación de archivo
                SharedPreferences.Editor editor = sp.edit(); //Gestión con editor

                String nombre = txtNombre.getText().toString(); //Captura de datos
                String apellido = txtApellido.getText().toString();

                editor.putString("nombre", nombre); //Guardado de datos
                editor.putString("apellido", apellido);
                editor.apply();

                Toast.makeText(MainActivity.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EL botón de cargar envía el foco a la segunda Activity, que cargará los datos
                Intent intent = new Intent(MainActivity.this, Segunda.class);
                startActivity(intent);
            }
        });
    }
}
