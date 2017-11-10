package com.example.a2dam.actividad3ad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad3AD extends AppCompatActivity {
    private EditText edNom;
    private EditText edApe;
    private Button Guardar;
    private EditText edDNI;
    private EditText fNac;
    private RadioGroup sexo;
    private String sexoSelect;
    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_ad);

        Guardar = (Button) findViewById(R.id.Guardar);
        edNom = (EditText) findViewById(R.id.edNom);
        edApe = (EditText) findViewById(R.id.edApe);
        edDNI = (EditText) findViewById(R.id.edDNI);
        fNac = (EditText) findViewById(R.id.fNac);
        sexo = (RadioGroup) findViewById(R.id.rgSexo);

        sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int select = sexo.getCheckedRadioButtonId();
                RadioButton radio = (RadioButton) findViewById(select);
                sexoSelect = (String) radio.getText();
            }
        });

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = String.valueOf(edNom.getText());
                String Apellido = String.valueOf(edApe.getText());
                String DNI = String.valueOf(edDNI.getText());
                String fechaNac = String.valueOf(fNac.getText());


                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Actividad3AD.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                editor.putString("Nombre", Nombre);
                editor.putString("Apellido", Apellido);
                editor.putString("Fecha", fechaNac);
                editor.putString("DNI", DNI);
                editor.putString("Sexo", sexoSelect);
                editor.commit();

                Toast.makeText(getApplicationContext(), "Cambios guardados", Toast.LENGTH_LONG).show();

                startActivity(new Intent(v.getContext() , Activity2.class));
            }
        });
    }
}
