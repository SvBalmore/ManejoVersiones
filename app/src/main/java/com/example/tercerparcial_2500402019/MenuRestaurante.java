package com.example.tercerparcial_2500402019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuRestaurante extends AppCompatActivity {
    Button salir;
    ImageButton menu1,menu2,menu3,menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurante);
        try {
            menu1 = findViewById(R.id.btnComida1);
            menu2 = findViewById(R.id.btnComida2);
            menu3 = findViewById(R.id.btnComida3);
            menu4 = findViewById(R.id.btnComida4);
            salir = findViewById(R.id.btnSalirRest);
            salir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Irmenu(view);
                }
            });

            menu1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    traer("btn1");
                }
            });
            menu2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    traer("btn2");
                }
            });
            menu3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    traer("btn3");
                }
            });
            menu4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    traer("btn4");
                }
            });


        }catch (Exception e){

        }
    }
    public void traer(String x){
        Intent intent = new Intent(this, InformacionRestaurante.class);
        intent.putExtra("boton", x.toString());

        startActivity(intent);
    }
    public void Irmenu(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}