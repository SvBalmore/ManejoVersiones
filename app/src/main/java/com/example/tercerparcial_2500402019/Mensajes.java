package com.example.tercerparcial_2500402019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mensajes extends AppCompatActivity {
    EditText txtmensaje;
    Button procesarMensaje,regresar;
    TextView salidaM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);
        txtmensaje = findViewById(R.id.txtMensajeRecordatorio);
        procesarMensaje = findViewById(R.id.btnRecordatorio);
        salidaM = findViewById(R.id.txtSalida);
        regresar = findViewById(R.id.btnSalirMensaje);

        SharedPreferences bdrecordatorio = getSharedPreferences("recordatorio", Context.MODE_PRIVATE);
        String salida = bdrecordatorio.getString("recordatorio","No se ha guardado ningun recordatorio");
        salidaM.setText(salida);


        procesarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseMensaje();
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegresarMenu(view);
            }
        });

    }
    public void BaseMensaje(){
        SharedPreferences bdrecordatorio = getSharedPreferences("recordatorio", Context.MODE_PRIVATE);
        String record = txtmensaje.getText().toString();
        SharedPreferences.Editor editor = bdrecordatorio.edit();
        editor.putString("recordatorio",record);
        editor.commit();
        String salida = bdrecordatorio.getString("recordatorio","No se ha guardado ningun recordatorio");
        salidaM.setText(salida);
    }
    public void RegresarMenu(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}