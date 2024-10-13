package ies.camas.mideporterepaso;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    RadioGroup rgTipo;
    Spinner spinner;
    TextView labelResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgTipo = findViewById(R.id.rgTipos);
        spinner = findViewById(R.id.spinner);
        labelResultado = findViewById(R.id.labelResultado);

        actualizaSpinner(R.array.depIndividual);

        rgTipo.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i == R.id.rbIndividual){
                actualizaSpinner(R.array.depIndividual);
            }else if(i == R.id.rbEnPareja){
                actualizaSpinner(R.array.depPareja);
            }else if(i == R.id.rbGrupal){
                actualizaSpinner(R.array.depGrupal);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String rbSeleccion = adapterView.getItemAtPosition(i).toString();
                labelResultado.setText(rbSeleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void actualizaSpinner(int arrayId){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,arrayId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}