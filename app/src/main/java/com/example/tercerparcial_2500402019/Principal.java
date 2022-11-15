package com.example.tercerparcial_2500402019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
ImageView btn1,btn2,btn3,btn4;
    //VARIABLES DE NAVBAR LATERAL
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    /////////////////FIN ///////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        btn1 = findViewById(R.id.mensajes);
        btn2 = findViewById(R.id.contactos);
        btn3 = findViewById(R.id.restaurante);
        btn4 = findViewById(R.id.alarma);




        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrAlarma(view);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrMensaje(view);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Irproveedores(view);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrRestaurante(view);
            }
        });
    }
    public void IrMensaje(View view){
        Intent intent = new Intent(this, Mensajes.class);
        startActivity(intent);
    }
    public void Irproveedores(View view){
        Intent intent = new Intent(this, proveedores.class);
        startActivity(intent);
    }

    public void IrRestaurante(View view){
        Intent intent = new Intent(this, MenuRestaurante.class);
        startActivity(intent);
    }
    public void IrAlarma(View view){
        Intent intent = new Intent(this, Entrega.class);
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            SharedPreferences bdRegistro = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            String nombre = bdRegistro.getString("nombre","admin");

            getMenuInflater().inflate(R.menu.menu, menu);

            super.onPrepareOptionsMenu(menu);
            menu.findItem(R.id.nav_account).setTitle(nombre);

        }catch (Exception e)
        {
            Toast.makeText(this, ""+e, Toast.LENGTH_LONG).show();
        }
        return true;
    }
}