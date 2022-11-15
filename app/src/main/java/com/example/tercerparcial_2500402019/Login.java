package com.example.tercerparcial_2500402019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
Button registro;
Button inicioSesion;
    EditText txtuser,txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registro = findViewById(R.id.btnRegistro);
        inicioSesion = findViewById(R.id.btnIniciar_sesion);
        txtuser = findViewById(R.id.txtUsuario);
        txtpass = findViewById(R.id.txtPassword);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrarse(view);
            }
        });
        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences bdRegistro = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                try {
                    String user = bdRegistro.getString("user","admin");
                    String pass = bdRegistro.getString("pass","123");

                    if (user.toString().equals(txtuser.getText().toString())){
                        if (pass.toString().equals(txtpass.getText().toString())){
                            MenuPrincipal(view);
                        }

                    }else{
                        Toast.makeText(Login.this, "El usuario no ha sido creado, o no coincide", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(Login.this, ""+e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Registrarse(View view){
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }
    public void MenuPrincipal(View view){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

}