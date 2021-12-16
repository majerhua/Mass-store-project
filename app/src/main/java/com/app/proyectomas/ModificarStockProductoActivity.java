package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.local.Producto.ProductoSQLiteManager;

public class ModificarStockProductoActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;

    EditText editTxtStock;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;

    int productoId = -1;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_stock_producto);

        Bundle b = getIntent().getExtras();

        if(b != null)
            productoId = b.getInt("productoId");


        productoSQLiteManager = new ProductoSQLiteManager(this);

        producto = productoSQLiteManager.getById(productoId);

        editTxtStock = findViewById(R.id.editTxtCodigo);

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


        editTxtStock.setText(String.valueOf(producto.getStock()));
        Toast.makeText(this,"Producto ID"+String.valueOf(productoId),Toast.LENGTH_SHORT).show();

    }

    public void modificar(){

        if(editTxtStock.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO STOCK ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else{
            productoSQLiteManager.updateStock(new Producto(
                    productoId,
                    Integer.parseInt(editTxtStock.getText().toString())
            ));
            Toast.makeText(this,"SE MODIFICO EL STOCK DEL PRODUCTO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, ListarModificarStockProductoActivity.class);
        startActivity(intent);
    }

}