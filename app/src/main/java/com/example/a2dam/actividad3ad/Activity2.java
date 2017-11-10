package com.example.a2dam.actividad3ad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a2dam.actividad3ad.Actividad3AD.PREFS;



public class Activity2 extends AppCompatActivity {


    private EditText edNom;
    private EditText edApe;
    private EditText edDNI;
    private EditText fNac;
    private EditText sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edNom = (EditText) findViewById(R.id.edNom);
        edApe = (EditText) findViewById(R.id.edApe);
        edDNI = (EditText) findViewById(R.id.edDNI);
        fNac = (EditText) findViewById(R.id.fNac);
        sexo = (EditText) findViewById(R.id.sex);

        SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Actividad3AD.MODE_PRIVATE);

        edNom.setText(mySharedPreferences.getString("Nombre", ""));
        edNom.setEnabled(false);
        edApe.setText(mySharedPreferences.getString("Apellido", ""));
        edApe.setEnabled(false);
        edDNI.setText(mySharedPreferences.getString("DNI", ""));
        edDNI.setEnabled(false);
        fNac.setText(mySharedPreferences.getString("Fecha", ""));
        fNac.setEnabled(false);
        sexo.setText(mySharedPreferences.getString("Sexo", ""));
        sexo.setEnabled(false);





    }
}
