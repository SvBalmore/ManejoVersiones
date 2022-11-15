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

public class Registrarse extends AppCompatActivity {
EditText nombre,user,pass,Rep_pass;
Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        nombre = findViewById(R.id.txtnombre);
        user = findViewById(R.id.txtuser);
        pass = findViewById(R.id.txtpass);
        Rep_pass = findViewById(R.id.txtrepetir);
        guardar = findViewById(R.id.btnGuardarRegistro);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar(view);
            }
        });

    }
    public void baseDatos(){

        SharedPreferences bdRegistro = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String nomb = nombre.getText().toString();
        String usuario = user.getText().toString();
        String contra= pass.getText().toString();

        SharedPreferences.Editor editor = bdRegistro.edit();
        editor.putString("nombre",nomb);
        editor.putString("user",usuario);
        editor.putString("pass",contra);
        editor.commit();
    }

    public void validar(View view)
    {
        if(nombre.getText().toString().isEmpty()){
            nombre.setError("Este campo no puede ir vacio");
            nombre.requestFocus();
        }else if (user.getText().toString().isEmpty()) {
            user.setError("Este campo no puede ir vacio");
            user.requestFocus();
        }  else if (pass.getText().toString().isEmpty()) {
            pass.setError("Este campo no puede ir vacio");
            pass.requestFocus();
        } else if (Rep_pass.getText().toString().isEmpty()) {
            Rep_pass.setError("Este campo no puede ir vacio");
            Rep_pass.requestFocus();
        }else if (!pass.getText().toString().equals(Rep_pass.getText().toString())) {
            Rep_pass.setError("Las contraseñas deben coincidir");
            Rep_pass.requestFocus();
        }else{
            Toast.makeText(this, "Usuario: "+nombre.getText().toString()+" se ha creado exitosamente", Toast.LENGTH_LONG).show();
            baseDatos();
            IrLogin(view);

        }
    }
    public void IrLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}