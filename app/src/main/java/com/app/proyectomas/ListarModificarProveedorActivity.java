package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.entity.Proveedor;
import com.app.proyectomas.local.Producto.ProductoSQLiteManager;
import com.app.proyectomas.local.Proveedor.ProveedorSQLiteManager;

import java.util.List;

public class ListarModificarProveedorActivity extends AppCompatActivity {

    ProveedorSQLiteManager proveedorSQLiteManager;
    private ListView lvProveedores;
    private ProveedorCustomAdapter proveedorCustomAdapter;
    List<Proveedor> proveedores;
    Button btnBuscarProductoPorCodigo;
    EditText editTxtBuscarCodigoProducto;
    Button btnListarProductos;
    Button btnRegresarMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_modificar_proveedor);

        proveedorSQLiteManager = new ProveedorSQLiteManager(this);
        proveedores = proveedorSQLiteManager.getAll();

        System.out.println(proveedores);

        lvProveedores = findViewById(R.id.lvProductos);
        btnBuscarProductoPorCodigo = findViewById(R.id.btnBuscarProductoPorCodigo);
        btnListarProductos = findViewById(R.id.btnListarProductos);
        editTxtBuscarCodigoProducto = findViewById(R.id.editTxtBuscarCodigoProducto);
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu);

        proveedorCustomAdapter = new ProveedorCustomAdapter(this,0,proveedores);
        lvProveedores.setAdapter(proveedorCustomAdapter);

        btnBuscarProductoPorCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarProveedorPorCodigo(editTxtBuscarCodigoProducto.getText().toString());
            }
        });

        btnListarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarProveedorPorCodigo("");
            }
        });

        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuActivity();
            }
        });
    }

    public void buscarProveedorPorCodigo(String pCodigo){
        proveedores = proveedorSQLiteManager.getAllByCodigo(pCodigo);
        proveedorCustomAdapter = new ProveedorCustomAdapter(this,0,proveedores);
        lvProveedores.setAdapter(proveedorCustomAdapter);
        proveedorCustomAdapter.notifyDataSetChanged();
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}