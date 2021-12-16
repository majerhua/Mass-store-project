package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.proyectomas.entity.Usuario;
import com.app.proyectomas.local.Usuario.UsuarioSQLiteManager;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    UsuarioSQLiteManager usuarioSQLiteManager;

    EditText editTxtNombre;
    EditText editTxtDni;
    EditText editTxtCorreo;
    EditText editTxtTelefono;
    EditText editTxtDireccion;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        usuarioSQLiteManager = new UsuarioSQLiteManager(this);

        editTxtNombre = findViewById(R.id.editTxtCodigo);
        editTxtDni = findViewById(R.id.editTxtEmpresa);
        editTxtCorreo = findViewById(R.id.editTxtTelefono);
        editTxtTelefono = findViewById(R.id.editTxtDireccion);
        editTxtDireccion = findViewById(R.id.editTxtRubro);

        btnRegistrarProducto = findViewById(R.id.btnRegistrarProducto);
        btnSalirOfRegistrarProducto = findViewById(R.id.btnSalirOfRegistrarProducto);

        btnRegistrarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        btnSalirOfRegistrarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuActivity();
            }
        });
    }

    public void registrar(){

        if(editTxtNombre.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO NOMBRE ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtDni.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO DNI ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtCorreo.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CORREO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtTelefono.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO TELÉFONO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtDireccion.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO DIRECCIÓN ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else{
            usuarioSQLiteManager.save(new Usuario(
                    editTxtNombre.getText().toString(),
                    editTxtDni.getText().toString(),
                    editTxtCorreo.getText().toString(),
                    editTxtTelefono.getText().toString(),
                    editTxtDireccion.getText().toString()
            ));
            Toast.makeText(this,"SE REGISTRO EL USUARIO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}