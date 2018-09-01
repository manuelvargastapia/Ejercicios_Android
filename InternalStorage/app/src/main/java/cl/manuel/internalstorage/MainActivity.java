package cl.manuel.internalstorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;
    private String nombre_archivo = "datos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
    }

    public void guardarDatos(View v){

        String texto = txtInput.getText().toString();

        FileOutputStream archivo = null;

        try{
            /*Obtención de archivo listo para ser editado. El segundo parámetro indica que el nuevo
            * contenido será adjuntado al contenido anterior, permitiendo conservarlo, sin
            * sobreescribir (como lo haría MODE_PRIVATE)*/
            archivo = openFileOutput(nombre_archivo, Context.MODE_APPEND);

            /*Escritura de los datos en el archivo que será guardado en el almacenamiento interno.
            * Solo funciona con bytes*/
            archivo.write(texto.getBytes());

        }catch (FileNotFoundException e){ //Excepción arrojada por openFileOutput()
            Log.i("guardarDatos: ", "FileNotFoundException de openFilseOutput()");
            e.printStackTrace();
        }catch (IOException e){ //Excepción arrojada por write()
            Log.i("guardarDatos: ", "IOException de write()");
            e.printStackTrace();
        }finally {
            if(archivo != null){ //Validación antes de seguir
                try{
                    archivo.close(); //Cierre de archivo y liberación de recursos de sistema asociados
                }catch (IOException e){
                    Log.i("guardarDatos: ", "IOException de close()");
                    e.printStackTrace();
                }
            }
        }
    }

    public void cargarDatos(View v) {

        TextView tv = findViewById(R.id.tv);

        FileInputStream archivo = null;

        StringBuilder sb = new StringBuilder();

        try{
            archivo = openFileInput(nombre_archivo); //Preparar archivo para ser leído
            int leer = 0;
            while((leer = archivo.read()) != -1){ //read() retorna -1 cuando no quedan bytes por leer
                sb.append((char) leer); //Traducir a char los bytes de archivo leídos por read() para
                                        //poder usar objeto SB
            }
            tv.setText(sb.toString()); //Convertir SB a String para poder ponerlo en tv

        }catch (FileNotFoundException e){
            Log.i("cargarDatos: ", "FileNotFoundExceptio de openFileInput()");
            e.printStackTrace();
        }catch (IOException e){
            Log.i("cargarDatos: ", "IOException de read()");
            e.printStackTrace();
        }finally {
            if(archivo != null){
                try{
                    archivo.close();
                }catch (IOException e){
                    Log.i("cargarDatos: ", "IOException de close()");
                    e.printStackTrace();
                }
            }
        }
    }
}
