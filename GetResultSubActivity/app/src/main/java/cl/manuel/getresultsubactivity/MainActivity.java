package cl.manuel.getresultsubactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables globales
    private static final int REQUEST_CODE = 1000; //Valor arbitrario. Es para detectar el origen de los datos
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preparación de elementos de activity_main.xml
        btn = findViewById(R.id.btnLaunch);
        txt = findViewById(R.id.txt);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Al clickear el botón, se envía un intent a la otra activity con el REQUEST_CODE
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE);//Se inicia la activity esperando que esta devuelva datos
        //Para ello, se utilizará en el futuro el REQUEST_CODE como una marca de la fuente de los datos
    }

    @Override //Método de Activity que reacciona al recibir datos de otras activities
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Evaluación de los datos arrojados por la SecondActivity
        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)){
            txt.setText(data.getStringExtra("secondactivity"));
        }//Se verifica si el REQUEST_CODE es el mismo que envió MainActivity y si está RESULT_OK,
        //lo que significa que la operación ha sido exitosa
        //Luego, se recuperan los datos usando la clave enviada por SecondActivity
    }
}
