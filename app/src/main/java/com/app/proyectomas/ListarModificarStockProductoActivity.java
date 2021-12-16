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

public class ListarModificarStockProductoActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;
    private ListView lvProductos;
    private ModificarStockCustomAdapter modificarStockCustomAdapter;
    List<Producto> productos;
    Button btnBuscarProductoPorCodigo;
    EditText editTxtBuscarCodigoProducto;
    Button btnBuscarProductoXQR;
    Button btnRegresarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_modificar_stock_producto);

        productoSQLiteManager = new ProductoSQLiteManager(this);
        productos = productoSQLiteManager.getAll();

        lvProductos = findViewById(R.id.lvProductos);
        btnBuscarProductoPorCodigo = findViewById(R.id.btnBuscarProductoPorCodigo);
        btnBuscarProductoXQR = findViewById(R.id.btnListarProductos);
        editTxtBuscarCodigoProducto = findViewById(R.id.editTxtBuscarCodigoProducto);
        btnRegresarMenu = findViewById(R.id.btnRegresarMenu);
        modificarStockCustomAdapter = new ModificarStockCustomAdapter(this,0,productos);
        lvProductos.setAdapter(modificarStockCustomAdapter);


        btnBuscarProductoPorCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarProductoPorCodigo(editTxtBuscarCodigoProducto.getText().toString());
            }
        });

        btnBuscarProductoXQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator =  new IntentIntegrator(ListarModificarStockProductoActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("ESCANEAR CODIGO QR DEL PRODUCTO");
                integrator.setCameraId(0);
                integrator.setOrientationLocked(false);
                integrator.setBeepEnabled(false);
                integrator.setCaptureActivity(AnyOrientationCaptureActivity.class);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuActivity();
            }
        });

    }

    public void buscarProductoPorCodigo(String pCodigo){
        productos = productoSQLiteManager.getAllByCodigo(pCodigo);
        modificarStockCustomAdapter = new ModificarStockCustomAdapter(this,0,productos);
        lvProductos.setAdapter(modificarStockCustomAdapter);
        modificarStockCustomAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null){
            if(scanResult.getContents()!=null){
                String contenido =  scanResult.getContents();
                buscarProductoPorCodigo(contenido);
            }else{
                Toast.makeText(this, "NO SE ESCANEO NADA.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "NO SE ESCANEO NADA.", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}