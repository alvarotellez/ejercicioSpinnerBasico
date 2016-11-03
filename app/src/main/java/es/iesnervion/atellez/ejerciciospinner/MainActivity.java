package es.iesnervion.atellez.ejerciciospinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private TextView seleccion;
    private Spinner spin;
    private String [] futbolistas = {"Arbeloa","Benzema","Reyes","Banega","Messi","Neymar","Poyet quedate"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buscamos la seleccion
        seleccion = (TextView) findViewById(R.id.seleccion);
        //Comprobamos que esta dentro del spinner
        spin = (Spinner) findViewById(R.id.spinner);
        //Escucha la op
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,futbolistas);

        //Damos un spinner por defecto
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Al spinner de xml le pasamos el adaptador(ArrayAdapter)
        spin.setAdapter(adaptador);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        seleccion.setText(futbolistas[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        seleccion.setText(" ");
    }
}
