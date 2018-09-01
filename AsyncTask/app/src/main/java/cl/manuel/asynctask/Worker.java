package cl.manuel.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class Worker extends AsyncTask<TextView, String, Boolean> {

    /*AsyncTask es genérica, y sus parámetros solicitan que especifiquemos los tipos. Los
    parámetros son <Params, Progress, Result>. Params: tipo de dato que se le pasará a AsyncTask,
    usualmente un elemento UI que debemos actualizar. Progress: tipo de dato que doInBackground le
    pasará a onProgressUpdate. Result: tipo de dato que especificará el estatus de doInBackground
    al terminar su operación.

    NOTA: AsyncTask es útil para operaciones que ocupan varios segundos, pero en casos donde se
    trate de minutos, el runtime nuevamente intervendrá. En esos casos, deben utilizarse Services*/

    private String TAG;
    private TextView tv;

    @Override //Único método obligatorio de implementar. Contendrá las tareas que exceden el tiempo
    protected Boolean doInBackground(TextView... textViews) {

        tv = textViews[0]; //El parámetro del método es un arreglo, pero al ser un solo elemento, usamos [0]
        TAG = getClass().getSimpleName();
        int i = 0;
        while(i++ < 15){
            try{
                Thread.sleep(2000);
                publishProgress(String.format("Value of i = %d", i));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override //Método que comunica periódicamente el progreso al usuario (luego de doInBackground)
    protected void onProgressUpdate(String... values) {
        //super.onProgressUpdate(values);
        tv.setText(values[0]);
        Log.i(TAG, String.format(values[0]));

        /*Este método toma como argumento cualquier valor (en forma de arreglo) que le pasemos al
        método publishProgress*/
    }
}
