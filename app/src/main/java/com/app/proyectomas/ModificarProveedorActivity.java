package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.proyectomas.entity.Proveedor;
import com.app.proyectomas.local.Proveedor.ProveedorSQLiteManager;

public class ModificarProveedorActivity extends AppCompatActivity {

    ProveedorSQLiteManager proveedorSQLiteManager;

    EditText editTxtCodigo;
    EditText editTxtEmpresa;
    EditText editTxtTelefono;
    EditText editTxtDireccion;
    EditText editTxtRubro;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;

    int proveedorId = -1;

    Proveedor proveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_proveedor);

        Bundle b = getIntent().getExtras();

        if(b != null)
            proveedorId = b.getInt("proveedorId");

        proveedorSQLiteManager = new ProveedorSQLiteManager(this);

        proveedor = proveedorSQLiteManager.getById(proveedorId);

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
                modificar();
            }
        });

        btnSalirOfRegistrarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuActivity();
            }
        });

        editTxtCodigo.setText(proveedor.getCodigo());
        editTxtEmpresa.setText(proveedor.getEmpresa());
        editTxtTelefono.setText(proveedor.getTelefono());
        editTxtDireccion.setText(proveedor.getDireccion());
        editTxtRubro.setText(proveedor.getRubro());
    }

    public void modificar(){

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
            proveedorSQLiteManager.update(new Proveedor(
                    proveedorId,
                    editTxtCodigo.getText().toString(),
                    editTxtEmpresa.getText().toString(),
                    editTxtTelefono.getText().toString(),
                    editTxtDireccion.getText().toString(),
                    editTxtRubro.getText().toString()
            ));
            Toast.makeText(this,"SE MODIFICO EL PROVEEDOR CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, ListarModificarProveedorActivity.class);
        startActivity(intent);
    }
}