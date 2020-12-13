package com.example.parseoxml2spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ConsultarXML.Comunicacion{
    Spinner spn_provincias;
    Spinner spn_municipios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn_provincias = findViewById(R.id.spn_provincias);
        spn_municipios = findViewById(R.id.spn_municipios);

        ConsultarXML cXML = new ConsultarXML();
        cXML.pedirProvincias(this);

        spn_provincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ConsultarXML.pedirMunicipio(MainActivity.this,parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void mostrarDatos(Provinciero r) {
        ArrayList<String> provincias = new ArrayList<String>();
        for (Provincia p : r.getProvinciero()){
            provincias.add(p.getNombre());
        }
        ArrayAdapter<Provincia> adaptador = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,provincias);
        spn_provincias.setAdapter(adaptador);
    }
    @Override
    public void mostrarDatos2(Municipiero r) {
        ArrayList<String> provincias = new ArrayList<String>();
        for (Municipio p : r.getmunicipiero()){
            provincias.add(p.getNombre());
        }
        ArrayAdapter<Municipio> adaptador = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,provincias);
        spn_municipios.setAdapter(adaptador);
    }
}