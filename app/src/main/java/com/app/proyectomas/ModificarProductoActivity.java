package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.local.Producto.ProductoSQLiteManager;

import java.util.Calendar;

public class ModificarProductoActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;

    EditText editTxtCodigo;
    EditText editTxtMarca;
    EditText editTxtCategoria;
    EditText editTxtPrecio;
    TextView txtEdiFVencimiento;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;

    int productoId = -1;
    Producto producto;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_producto);

        Bundle b = getIntent().getExtras();

        if(b != null)
            productoId = b.getInt("productoId");

        Toast.makeText(this,String.valueOf(productoId),Toast.LENGTH_SHORT).show();

        productoSQLiteManager = new ProductoSQLiteManager(this);

        producto = productoSQLiteManager.getById(productoId);

        editTxtCodigo = findViewById(R.id.editTxtCodigo);
        editTxtMarca = findViewById(R.id.editTxtEmpresa);
        editTxtCategoria = findViewById(R.id.editTxtTelefono);
        editTxtPrecio = findViewById(R.id.editTxtDireccion);
        txtEdiFVencimiento = findViewById(R.id.txtEdiFVencimiento);

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

        editTxtCodigo.setText(producto.getCodigo());
        editTxtMarca.setText(producto.getMarca());
        editTxtCategoria.setText(producto.getCategoria());
        editTxtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtEdiFVencimiento.setText(producto.getFechaVencimiento());

        txtEdiFVencimiento.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ModificarProductoActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" +year;

                if(month < 10){
                    date = dayOfMonth + "/0" + month + "/" +year;
                }

                if(dayOfMonth < 10){
                    date = "0"+dayOfMonth + "/" + month + "/" +year;
                }

                if(month < 10 && dayOfMonth < 10){
                    date = "0"+dayOfMonth + "/0" + month + "/" +year;
                }

                txtEdiFVencimiento.setText(date);
            }
        };

    }

    public void modificar(){

        if(editTxtCodigo.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CÓDIGO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtMarca.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO MARCA ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtCategoria.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CATEGORIA ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtPrecio.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO PRECIO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(txtEdiFVencimiento.getText().toString().equals("Clic aquí para agregar fecha de vencimiento")){
            Toast.makeText(this,"EL CAMPO FECHA VENCIMIENTO ES REQUERIDO.",Toast.LENGTH_SHORT).show();
        }else{
            productoSQLiteManager.update(new Producto(
                    productoId,
                    editTxtCodigo.getText().toString(),
                    editTxtMarca.getText().toString(),
                    editTxtCategoria.getText().toString(),
                    Double.parseDouble(editTxtPrecio.getText().toString()),
                    txtEdiFVencimiento.getText().toString()
            ));
            Toast.makeText(this,"SE MODIFICO EL PRODUCTO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, ListarModificarProductoActivity.class);
        startActivity(intent);
    }
}