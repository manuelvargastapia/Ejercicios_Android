package cl.manuel.getresultsubactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btnEnviar);
        btn.setOnClickListener(new View.OnClickListener() {//Clase anónima
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                EditText txt = findViewById(R.id.txtInput);
                String data = txt.getText().toString();//Capturar datos del input
                intent.putExtra("secondactivity", data);//Almacenarlos en clave/valor en intent
                setResult(Activity.RESULT_OK, intent);//Enviar intent junto con aviso de OK
                finish();//Matar activity (retornar foco a MainActivity)
            }
        });
    }
}
