package com.example.tercerparcial_2500402019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class proveedores extends AppCompatActivity {
TextView txtsalida;
EditText empresa,persona,tel;
Button btnProcesarContacto,mn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);
        txtsalida = findViewById(R.id.txtSalidaContact);
        empresa = findViewById(R.id.txtempresa);
        persona = findViewById(R.id.txtcontacto);
        tel = findViewById(R.id.txtcel);
        mn = findViewById(R.id.regresarmenu);

        mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegresarMenu(view);
            }
        });



        SharedPreferences bdContacto = getSharedPreferences("contacto", Context.MODE_PRIVATE);
        String s1 = bdContacto.getString("empresa","No se ha ");
        String s2 = bdContacto.getString("persona","guardado ");
        String s3 = bdContacto.getString("tel","ningun contactos");
        txtsalida.setText(s1+"\n"+s2+"\n"+s3);

        btnProcesarContacto = findViewById(R.id.btnContacto);
        btnProcesarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseContacto(view);
            }
        });

    }
    public void baseContacto(View view){
        SharedPreferences bdContacto = getSharedPreferences("contacto", Context.MODE_PRIVATE);
        String em = empresa.getText().toString();
        String pe = persona.getText().toString();
        String tl = tel.getText().toString();
        SharedPreferences.Editor editor = bdContacto.edit();
        editor.putString("empresa",em);
        editor.putString("persona",pe);
        editor.putString("tel",tl);
        editor.commit();
        String s1 = bdContacto.getString("empresa","No se ha ");
        String s2 = bdContacto.getString("persona","guardado ");
        String s3 = bdContacto.getString("tel","ningun contactos");
        txtsalida.setText(s1+"\n"+s2+"\n"+s3);
    }
    public void RegresarMenu(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}