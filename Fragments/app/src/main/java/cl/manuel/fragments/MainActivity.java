package cl.manuel.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*En activity_main, el fragment recién creado puede agregarse como un componente más
        (gracias a que es un ViewGroup), ya sea de modo estático/declarativo o programático.
        La primer manera, supone simplemente insertar, en el tiempo de diseño, el fragment,
        directamente desde la paleta de componentes. La segunda forma, en cambio, implica el
        uso de FragmentManager y FragmentTransaction para agregar dinámicamente los fragments
        en tiempo de ejecución, permitiendo mayor responsividad*/

    }
}
