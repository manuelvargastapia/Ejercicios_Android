package cl.manuel.intentexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        //Manejo de evento programáticamente (no modifica el XML)
        Button closeButton = findViewById(R.id.btnVolver);//Enlace
        assert closeButton != null;//Seguridad de que no sea vacío (defense coding)

        /*Clase anónima que implementa onClick, el cual detona finish() (método de que
         destruye esta Activity)*/
        closeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
