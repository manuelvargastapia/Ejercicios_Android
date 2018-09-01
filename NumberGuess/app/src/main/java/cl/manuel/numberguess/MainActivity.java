package cl.manuel.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

//Implementación de OnClickListener directamente en MainActivity
/*Esto proporciona una ventaja porque evita crear una clase interna o anónima, lo que implicaría
la utilización de variables final, lo que complejiza innecesariamente el código*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables inicializadas en onCreate, pero también referenciadas en onClick
    int numberToGuess = 0;
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberToGuess = initNumberToGuess(); //inicialización de número a adivinar
        e = (EditText) findViewById(R.id.editText); //enlaces a vistas
        t = (TextView) findViewById(R.id.textView);
        Button b = (Button) findViewById(R.id.button);//Variable local
        b.setOnClickListener(this); //establecimiento del botón como el oyente de esta
                                    //misma activity
    }

    //Método que recibe el input del usuario y lo compara con el número a adivinar
    @Override
    public void onClick(View view) {

        //Captura del número del usuario. Para parsearlo, se requiere de un String
        int number = Integer.parseInt(e.getText().toString());

        //Evaluación
        if(number == numberToGuess){
            t.setText(number + " is the right number!");
        }else if(number < numberToGuess){
            t.setText("Guess higher!");
        }else if(number > numberToGuess){
            t.setText("Guess lower!");
        }

        //Muestra un mensaje en Logcat
        Log.i("Manuel", numberToGuess + "");
    }

    int initNumberToGuess(){
        Random r = new Random();//Construcción de objeto Random
        numberToGuess = r.nextInt(100) + 50;//El rango de r es de 100 a 150
        Log.i("Manuel", numberToGuess + "");
        return numberToGuess;
    }
}
