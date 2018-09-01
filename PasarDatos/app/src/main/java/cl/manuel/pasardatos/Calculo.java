package cl.manuel.pasardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo);

        //Variables locales
        TextView resultado = findViewById(R.id.txtResultado);
        int mayor = 0;
        int menor = 0;
        int resto = 1;
        int primer_numero = 0;
        int segundo_numero = 0;

        Intent intent = getIntent();//Lo primero es recuperar el intent enviado por MainActivity
        Bundle bundle = intent.getBundleExtra("mcdData");//Luego, se recupera el extra del intent

        //Ahora podemos "desempaquetar" los valores del bundle
        if((bundle != null) & !bundle.isEmpty()){
            primer_numero = bundle.getInt("num1", 1);//El segundo valor es opcional
            segundo_numero = bundle.getInt("num2", 1);
        }

        //Algoritmo de cálculo
        if(primer_numero > segundo_numero){
            mayor = primer_numero;
            menor = segundo_numero;
        }else{
            mayor = segundo_numero;
            menor = primer_numero;
        }
        while((resto = mayor % menor) != 0){
            mayor = menor;
            menor = resto;
        }
        resultado.setText(String.format("%d", menor));
    }
}
