package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.local.Producto.ProductoSQLiteManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Date;
import java.util.List;

public class ReporteProductoActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;
    private ListView lvProductos;
    private ProductoCustomAdapter productoCustomAdapter;
    List<Producto> productos;
    Button btnBuscarProductoPorCodigo;
    TextView txtFechaHoy;
    Button btnBuscarProductoXQR;
    Button btnRegresarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_producto);

        productoSQLiteManager = new ProductoSQLiteManager(this);
        productos = productoSQLiteManager.getAll();

        lvProductos = findViewById(R.id.lvProductos);
        btnBuscarProductoPorCodigo = findViewById(R.id.btnBuscarProductoPorCodigo);
        btnBuscarProductoXQR = findViewById(R.id.btnListarProductos);
        txtFechaHoy = findViewById(R.id.txtFechaHoy);
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu);

        Date date = new Date();

        int dia = date.getDate();
        int mes = date.getMonth();
        int anio = date.getYear() + 1900;

        String fecha = "";

        if((mes + 1) < 10){
            fecha = dia + "/0" + (mes + 1) + "/" +anio;
        }

        if(dia < 10){
            fecha = "0"+dia + "/" + (mes + 1) + "/" +anio;
        }

        if((mes + 1) < 10 && dia < 10){
            fecha = "0"+dia + "/0" + (mes + 1) + "/" +anio;
        }

        txtFechaHoy.setText(fecha);

        productoCustomAdapter = new ProductoCustomAdapter(this,0,productos);
        lvProductos.setAdapter(productoCustomAdapter);

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
}