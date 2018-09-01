package cl.manuel.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override //Sobreescritura de método de creación de opciones de menú
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override//Sobreescritura de método para manejar eventos de menú
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuArchivo:
                mostrarMensaje("Archivo");
                break;
            case R.id.menuAyuda:
                mostrarMensaje("Ayuda");
                break;
            case R.id.menuEditar:
                mostrarMensaje("Editar");
                break;
            case R.id.menuSalir:
                mostrarMensaje("Salir");
                break;
            default:
                mostrarMensaje("No se ha oprimido un botón de menú");
            }
        return true;
    }

    public void mostrarMensaje(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
