package cl.manuel.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Demostración de persistencia de datos con SharedPreferences.
    * SharedPreferences crea un archivo XML, aunque solo con datos primitivos y String, almacenado
    * internamente en el aparato Android. Puede verificarse usando el Android Device Monitor o
    * Device File Explorer. El archivo generado tendrá el mismo nombre que la clase que invocó
    * a la clase SharedPreferences. Ruta: "data/data/[dominio].[nombredeapp]/[nombre_de_app]/"*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnCargar = findViewById(R.id.btnCargar);

        /*Estas variables deben ser declaradas final debido a que están siendo utilizadas
        por clases internas-anónimas*/
        final EditText txtNombre = findViewById(R.id.txtNombre);
        final EditText txtApellido = findViewById(R.id.txtApellido);
        final TextView tv = findViewById(R.id.tv);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creación de objeto SP. Si no existe, se crea uno; si ya existe uno, se utiliza
                //El parámetro es el modo de acceso a los datos. En este caso, se trata de un
                //archivo que no puede ser accesado desde fuera de esta Activity
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);

                //El objeto Editor sirve de interfaz para gestionar los datos de SP
                SharedPreferences.Editor editor = sp.edit();

                //Captura de los datos ingresados por el usuario en los EditText
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();

                //El objeto Editor almacena los datos en archivo SP en formato clave-valor
                editor.putString("nombre", nombre);
                editor.putString("apellido", apellido);

                //Objeto Editor hace efectivos los cambios (recién aquí se consigue la persistencia)
                editor.apply();

                Toast.makeText(MainActivity.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Como Android sabe que ya existe un sp, aquí simplemente lo entrega
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);

                //Obtención de los datos de sp
                String nombre = sp.getString("nombre", "no");
                String apellido = sp.getString("apellido", "ap");

                tv.setText(String.format("%s %s", nombre, apellido));
            }
        });
    }
}
