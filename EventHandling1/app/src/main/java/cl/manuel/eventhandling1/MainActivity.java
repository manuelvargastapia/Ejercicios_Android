package cl.manuel.eventhandling1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Construcción y enlaces para manejar los eventos
        ButtonHandler bh = new ButtonHandler();
        findViewById(R.id.btn1).setOnClickListener(bh);
        findViewById(R.id.btn2).setOnClickListener(bh);
        findViewById(R.id.btn3).setOnClickListener(bh);
    }

    //Clase interna y privada que será utilizada como listener
    private class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View view) { //Se pasa por parámetro la vista que detonó el método
            switch (view.getId()){       //Se utiliza el atributo id de la vista para la evaluación
                case R.id.btn1:
                    show("Button One");  //Se invoca el método show
                    break;
                case R.id.btn2:
                    show("Button Two");
                    break;
                case R.id.btn3:
                    show("Button Three");
                    break;
                default:
                    show("This shouldn't happen");
            }
        }
    }

    void show(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show(); //Pequeño pop-up
        Log.i(getClass().getName(), message);//Mensaje de diagnóstico para Logcat
    }
}
