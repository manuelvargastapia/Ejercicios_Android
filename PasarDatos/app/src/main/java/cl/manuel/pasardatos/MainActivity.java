package cl.manuel.pasardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables de clase, porque deben ser usados en onCreate y onClick
    private EditText num1;
    private EditText num2;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlaces y manejo de evento de botón
        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        calcular = findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(this);
    }

    //Método de clase Activity para el control del ciclo de vida la activity
    //Se ejecuta por primera vez al arrancar la apliación, y luego cada vez que el foco es
    //devuelto a esta activity. Por lo tanto, cada vez que se ejecute, se limpian los EditText
    @Override
    protected void onStart() {
        super.onStart();

        num1.setText("");
        num2.setText("");
    }

    @Override
    public void onClick(View view) {

        //Verificar que ningún EditText esté vacío
        boolean a = TextUtils.isEmpty(num1.getText());//TextUtils es útil para estas tareas
        boolean b = TextUtils.isEmpty(num2.getText());

        if(!a & !b){ //Esto asegura que se evalúan ambas variables antes de seguir
            int primer_numero = Integer.parseInt(num1.getText().toString());
            int segundo_numero = Integer.parseInt(num2.getText().toString());

            //Exportación de datos para ser calculados en activity Calculo
            Intent intent = new Intent(this, Calculo.class);//Se usa el archivo .class (Java compilado)
            Bundle bundle = new Bundle();//Bundle almacena datos como "clave/valor", como un diccionario
            bundle.putInt("num1", primer_numero);//También almacena strings con putString(), por ej
            bundle.putInt("num2", segundo_numero);
            intent.putExtra("mcdData", bundle);//Función análoga a la de Bundle, en formato "clave/valor"
            startActivity(intent);
        }
    }
}
