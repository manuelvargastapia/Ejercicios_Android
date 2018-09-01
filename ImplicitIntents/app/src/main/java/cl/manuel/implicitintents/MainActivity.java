package cl.manuel.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/*Los intent implícitos son intents que no expecifican quién debe realizar determinada acción.
* Es como si solicitaran abiertamente a otros componentes, dependiendo de sus capacidades, que
* solucionen un asunto, sin importar cuándo ni como. En concreto, se le pide al Android Runtime
* que se encargue de poner a una Activity o componente a trabajar, sin importar quién sea ni
* cómo lo haga*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Oyendo los 3 botones de manera anónima
        findViewById(R.id.btnWeb).setOnClickListener(this);
        findViewById(R.id.btnMapa).setOnClickListener(this);
        findViewById(R.id.btnNumero).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Inicializaciones de variables relevantes
        Uri uri = null;
        Intent intent = null;

        switch (view.getId()){//Se evalúa qué botón detonó el onClick
            case R.id.btnWeb: //Lanza navegador y abriri jacobinmag.com
                uri = Uri.parse("http://www.jacobinmag.com");//Convertir URL en URI
                intent = new Intent(Intent.ACTION_VIEW, uri);//Especificar acción via constante de Intent
                startActivity(intent);
                Log.i(getClass().getName(), "Pulento");
                break;
            case R.id.btnMapa://Lanza Google Maps y abrir localización
                uri = Uri.parse("geo:40.7113399,-74.0263469");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Log.i(getClass().getName(), "De choro");
                break;
            case R.id.btnNumero://Lanza la app de marcado
                uri = Uri.parse("tel:2232181992");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                Log.i(getClass().getName(), "De Jhon von vovi");
                break;
            default:
                Log.i(getClass().getName(), "Depura la weá");
        }//Es importante que se utilicen los formatos aquí usados (http://..., geo:..., tel:...)
    }
}
