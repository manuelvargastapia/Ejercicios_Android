package cl.manuel.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Manejo de evento declarativamente (ver XML de botón)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SubActivity.class); //Construcción de intent
        startActivity(intent);//Invocación de método de gatilla intent (comenzar la SubActivity)
    }
    
}
