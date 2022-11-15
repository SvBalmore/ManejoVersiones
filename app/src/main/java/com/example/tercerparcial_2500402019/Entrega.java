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

public class Entrega extends AppCompatActivity {
EditText v1,v2,v3,v4;
TextView sa;
Button proc,slr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega);
        v1 = findViewById(R.id.txtnp);
        v2 = findViewById(R.id.txtpedido);
        v3 = findViewById(R.id.txtdirec);
        v4 = findViewById(R.id.txtcont);
        sa = findViewById(R.id.txtsa);
        proc = findViewById(R.id.btnEnvio);
        slr = findViewById(R.id.btnsa);

        slr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegresarMenu(view);
            }
        });
        SharedPreferences bdreEntrega = getSharedPreferences("Entrega", Context.MODE_PRIVATE);
        String s1 = bdreEntrega.getString("va1","No se ha ");
        String s2 = bdreEntrega.getString("va2","guardado ");
        String s3 = bdreEntrega.getString("va3","ningun ");
        String s4 = bdreEntrega.getString("va4","pedido");
        sa.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4);

        proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseEntrega(view);
            }
        });
    }
    public void BaseEntrega(View view){
        SharedPreferences bdreEntrega = getSharedPreferences("Entrega", Context.MODE_PRIVATE);
        String va1 = v1.getText().toString();
        String va2 = v2.getText().toString();
        String va3 = v3.getText().toString();
        String va4 = v4.getText().toString();
        SharedPreferences.Editor editor = bdreEntrega.edit();
        editor.putString("va1",va1);
        editor.putString("va2",va2);
        editor.putString("va3",va3);
        editor.putString("va4",va4);
        editor.commit();
        String s1 = bdreEntrega.getString("va1","No se ha ");
        String s2 = bdreEntrega.getString("va2","guardado ");
        String s3 = bdreEntrega.getString("va3","ningun ");
        String s4 = bdreEntrega.getString("va4","pedido");
        sa.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4);
    }
    public void RegresarMenu(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}