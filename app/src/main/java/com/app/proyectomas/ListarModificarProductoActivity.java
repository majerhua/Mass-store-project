package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.local.Producto.ProductoSQLiteManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

public class ListarModificarProductoActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;
    private ListView lvProductos;
    private ModificarProductoCustomAdapter modificarProductoCustomAdapter;
    List<Producto> productos;
    Button btnBuscarProductoPorCodigo;
    EditText editTxtBuscarCodigoProducto;
    Button btnListarProductos;
    Button btnRegresarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_modificar_producto);

        productoSQLiteManager = new ProductoSQLiteManager(this);
        productos = productoSQLiteManager.getAll();

        System.out.println(productos);

        lvProductos = findViewById(R.id.lvProductos);
        btnBuscarProductoPorCodigo = findViewById(R.id.btnBuscarProductoPorCodigo);
        btnListarProductos = findViewById(R.id.btnListarProductos);
        editTxtBuscarCodigoProducto = findViewById(R.id.editTxtBuscarCodigoProducto);
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu);

        modificarProductoCustomAdapter = new ModificarProductoCustomAdapter(this,0,productos);
        lvProductos.setAdapter(modificarProductoCustomAdapter);


        btnBuscarProductoPorCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarProductoPorCodigo(editTxtBuscarCodigoProducto.getText().toString());
            }
        });

        btnListarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarProductoPorCodigo("");
            }
        });

        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuActivity();
            }
        });

    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buscarProductoPorCodigo(String pCodigo){
        productos = productoSQLiteManager.getAllByCodigo(pCodigo);
        modificarProductoCustomAdapter = new ModificarProductoCustomAdapter(this,0,productos);
        lvProductos.setAdapter(modificarProductoCustomAdapter);
        modificarProductoCustomAdapter.notifyDataSetChanged();
    }

}