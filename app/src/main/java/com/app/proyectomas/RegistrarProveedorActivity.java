package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.proyectomas.entity.Proveedor;
import com.app.proyectomas.entity.Usuario;
import com.app.proyectomas.local.Proveedor.ProveedorSQLiteManager;
import com.app.proyectomas.local.Usuario.UsuarioSQLiteManager;

public class RegistrarProveedorActivity extends AppCompatActivity {

    ProveedorSQLiteManager proveedorSQLiteManager;

    EditText editTxtCodigo;
    EditText editTxtEmpresa;
    EditText editTxtTelefono;
    EditText editTxtDireccion;
    EditText editTxtRubro;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_proveedor);

        proveedorSQLiteManager = new ProveedorSQLiteManager(this);

        editTxtCodigo = findViewById(R.id.editTxtCodigo);
        editTxtEmpresa = findViewById(R.id.editTxtEmpresa);
        editTxtTelefono = findViewById(R.id.editTxtTelefono);
        editTxtDireccion = findViewById(R.id.editTxtDireccion);
        editTxtRubro = findViewById(R.id.editTxtRubro);

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

        if(editTxtCodigo.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CÓDIGO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtEmpresa.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO EMPRESA ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtTelefono.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO TELEFONO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtDireccion.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO DIRECCION ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtRubro.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO RUBRO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else{
            proveedorSQLiteManager.save(new Proveedor(
                    editTxtCodigo.getText().toString(),
                    editTxtEmpresa.getText().toString(),
                    editTxtTelefono.getText().toString(),
                    editTxtDireccion.getText().toString(),
                    editTxtRubro.getText().toString()
            ));
            Toast.makeText(this,"SE REGISTRO EL PROVEEDOR CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}