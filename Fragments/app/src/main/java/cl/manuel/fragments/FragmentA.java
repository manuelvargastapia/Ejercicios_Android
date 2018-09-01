package cl.manuel.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    //Sobreescritura de método de Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        /*Al igual que setContentView de Activity, inflate utiliza el XML del layout para crear un
        * objeto Java al que hacer referencia. Luego, adjunta ese objeto al contenedor del fragment (container),
        * que en este caso es Activity. El último parámetro especifica si el layout será agregado a otro como
        * componente (a la raíz en una jerarquía)*/

        View vista = inflater.inflate(R.layout.fragment_a, container, false);

        return vista;
    }
}
