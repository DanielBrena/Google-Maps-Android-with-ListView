package ulsa.brena.com.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ulsa.brena.com.maps.adapter.ListViewAdapter;
import ulsa.brena.com.maps.adapter.Ubicacion;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        if (getUbicaciones().size() > 0){
            listViewAdapter = new ListViewAdapter(getApplicationContext(),R.layout.item_list,getUbicaciones());
            listView.setAdapter(listViewAdapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private ArrayList<Ubicacion> getUbicaciones(){
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();
        ubicaciones.add(new Ubicacion("Lugar Uno","17.020765", "-96.724263"));
        ubicaciones.add(new Ubicacion("Lugar Dos","17.022694", "-96.724349"));
        ubicaciones.add(new Ubicacion("Lugar Tres","17.023432", "-96.721860"));
        ubicaciones.add(new Ubicacion("Lugar Cuatro","17.022488", "-96.719456"));
        ubicaciones.add(new Ubicacion("Lugar Cinco","17.020847", "-96.719070"));
        ubicaciones.add(new Ubicacion("Lugar Seis","17.019124", "-96.719885"));
        return  ubicaciones;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
