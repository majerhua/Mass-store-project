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

public class RegistrarProductosActivity extends AppCompatActivity {

    ProductoSQLiteManager productoSQLiteManager;

    EditText editTxtCodigo;
    EditText editTxtMarca;
    EditText editTxtCategoria;
    EditText editTxtPrecio;

    Button btnRegistrarProducto;
    Button btnSalirOfRegistrarProducto;
    TextView txtFechaVencimiento;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_productos);

        productoSQLiteManager = new ProductoSQLiteManager(this);

        editTxtCodigo = findViewById(R.id.editTxtCodigo);
        editTxtMarca = findViewById(R.id.editTxtEmpresa);
        editTxtCategoria = findViewById(R.id.editTxtTelefono);
        editTxtPrecio = findViewById(R.id.editTxtDireccion);
        txtFechaVencimiento = findViewById(R.id.txtFechaVencimiento);

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

        txtFechaVencimiento.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        RegistrarProductosActivity.this,
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

                txtFechaVencimiento.setText(date);
            }
        };
    }


    public void registrar(){


        if(editTxtCodigo.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CÓDIGO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtMarca.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO MARCA ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtCategoria.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO CATEGORIA ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtPrecio.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO PRECIO ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(txtFechaVencimiento.getText().toString().equals("Clic aquí para agregar fecha de vencimiento")){
            Toast.makeText(this,"EL CAMPO FECHA VENCIMIENTO ES REQUERIDO.",Toast.LENGTH_SHORT).show();
        }else{
            productoSQLiteManager.save(new Producto(
                    editTxtCodigo.getText().toString(),
                    editTxtMarca.getText().toString(),
                    editTxtCategoria.getText().toString(),
                    Double.parseDouble(editTxtPrecio.getText().toString()),
                    txtFechaVencimiento.getText().toString()
            ));
            Toast.makeText(this,"SE REGISTRO EL PRODUCTO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            changeMenuActivity();
        }
    }

    public void changeMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}