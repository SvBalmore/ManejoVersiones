package com.example.tercerparcial_2500402019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformacionRestaurante extends AppCompatActivity {
    TextView desc;
    Button salirinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_restaurante);
        String boton = getIntent().getExtras().getString("boton");
        salirinfo = findViewById(R.id.btnmenu);
        desc = findViewById(R.id.txtrespuestas);
        if (boton.equals("btn1") )
        {
            desc.setText("Plato de carne de res\nPrecio: $12.24");

        }
        if (boton.equals("btn2") )
        {
            desc.setText("Plato de Chicharrones \nPrecio: $10.2");
        }
        if (boton.equals("btn3") )
        {
            desc.setText("Plato de Enchiladas.\n Precio: 6.5");
        }
        if (boton.equals("btn4") )
        {
            desc.setText("Plato de pupusas \n Precio: 7.5");
        }


        salirinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamar(view);
            }
        });
    }
    public void llamar(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}