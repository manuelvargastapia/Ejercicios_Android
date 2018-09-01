package cl.manuel.fragment2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inclusión programática de fragment en acitivy_main, de modo que sea integrada en runtime

        FragmentA f = new FragmentA(); //Creación de instancia de FragmentA
        FragmentManager fm = getFragmentManager(); //Obtener FM para MainActivity
        FragmentTransaction ft = fm.beginTransaction(); //Si FM inicia una transacción, retorna un FT
        ft.add(R.id.frag_placeholder, f, ""); //Agregar ViewGroup fragment + instancia de FragmentA + String
        ft.commit(); //Hacer al fragment visible en actividad

        //El frag_contenedor agregado se requiere para alojar la instancia de FragmentA, que
        //solo será visible en runtime
    }
}
