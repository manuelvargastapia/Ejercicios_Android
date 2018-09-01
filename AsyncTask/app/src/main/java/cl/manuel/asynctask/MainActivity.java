package cl.manuel.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Aplicación destinada a exceder el tiempo de espera para ejecutar una tarea (5 segundos máx)

    /*El objetivo es mostrar las capacidades de la ejecución en segundo plano, o mejor dicho,
     *las tareas asíncronas, usando la clase AsyncTask*/

    private String TAG;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        tv = findViewById(R.id.textView);
        TAG = getClass().getSimpleName();

        b.setOnClickListener(this);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.i(TAG, "Clicked");
            }
        });
    }

    @Override
    public void onClick(View view) {

        /*int i = 0;
        while (i < 15) {
            try {
                Thread.sleep(2000); //Pausa de 2 seg cada vez que se imprime un valor
                tv.setText(String.format("Value of i = %d", i)); //La pantalla se congela y la app se cierra
                Log.i(TAG, String.format("value of i = %d", i++ ));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        //All the previous code can be replaced for this one, now that we've implemented AsyncTask:

        Worker worker = new Worker(); //Creación de instancia de Worker (AsyncTask)
        worker.execute(tv); //Inicio de funciones de AsyncTask (doInBackground). Se pasa por
                            //parámetro el elemento que queremos actualizar; pueden ser múltiples,
                            //ya que el argumento que recibe es un arreglo

    }
}
