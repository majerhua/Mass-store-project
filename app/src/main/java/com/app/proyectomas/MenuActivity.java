package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.app.proyectomas.local.Usuario.SessionManagement;

public class MenuActivity extends AppCompatActivity {

    ImageButton btnImageSalir;
    Button btnRegistrarNuevoProducto;
    Button btnBuscarProductos;
    Button btnModificarProductos;
    Button btnConsultarStockProductos;
    Button btnActualizarStockProductos;
    Button btnRegistrarNuevoUsuario;
    Button btnRegistrarNuevoProveedor;
    Button btnModificarProveedores;
    Button btnReporteProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnImageSalir = findViewById(R.id.btnImageSalir);
        btnRegistrarNuevoProducto = findViewById(R.id.btnRegistrarNuevoProducto);
        btnBuscarProductos = findViewById(R.id.btnBuscarProductos);
        btnModificarProductos = findViewById(R.id.btnModificarProductos);
        btnConsultarStockProductos = findViewById(R.id.btnConsultarStockProductos);
        btnActualizarStockProductos = findViewById(R.id.btnActualizarStockProductos);
        btnRegistrarNuevoUsuario = findViewById(R.id.btnRegistrarNuevoUsuario);
        btnRegistrarNuevoProveedor = findViewById(R.id.btnRegistrarNuevoProveedor);
        btnModificarProveedores = findViewById(R.id.btnModificarProveedores);
        btnReporteProductos = findViewById(R.id.btnReporteProductos);

        btnBuscarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBuscarProductoActivity();
            }
        });

        btnRegistrarNuevoProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRegistrarProductoActivity();
            }
        });

        btnModificarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeModificarProductoActivity();
            }
        });

        btnImageSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnConsultarStockProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeConsultarStockProductoActivity();
            }
        });

        btnActualizarStockProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeModificarStockProductoActivity();
            }
        });

        btnRegistrarNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRegistrarNuevoUsuarioActivity();
            }
        });

        btnRegistrarNuevoProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRegistrarProveedorActivity();
            }
        });

        btnModificarProveedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeModificarProveedorActivity();
            }
        });

        btnReporteProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeReporteProductoActivity();
            }
        });

        SessionManagement sessionManagement = new SessionManagement(this);

        int rol = sessionManagement.getRol();

        if(rol == 0){
            btnActualizarStockProductos.setEnabled(false);

            Drawable buttonDrawable = btnActualizarStockProductos.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.GRAY);
            btnActualizarStockProductos.setBackground(buttonDrawable);

        }else if(rol == 1){
            btnModificarProductos.setEnabled(false);

            Drawable buttonDrawable2 = btnModificarProductos.getBackground();
            buttonDrawable2 = DrawableCompat.wrap(buttonDrawable2);
            DrawableCompat.setTint(buttonDrawable2, Color.GRAY);
            btnModificarProductos.setBackground(buttonDrawable2);

            btnRegistrarNuevoProveedor.setEnabled(false);

            Drawable buttonDrawable3 = btnRegistrarNuevoProveedor.getBackground();
            buttonDrawable3 = DrawableCompat.wrap(buttonDrawable3);
            DrawableCompat.setTint(buttonDrawable3, Color.GRAY);
            btnRegistrarNuevoProveedor.setBackground(buttonDrawable3);

            btnRegistrarNuevoProducto.setEnabled(false);

            Drawable buttonDrawable4 = btnRegistrarNuevoProducto.getBackground();
            buttonDrawable4 = DrawableCompat.wrap(buttonDrawable4);
            DrawableCompat.setTint(buttonDrawable4, Color.GRAY);
            btnRegistrarNuevoProducto.setBackground(buttonDrawable4);

            btnRegistrarNuevoUsuario.setEnabled(false);

            Drawable buttonDrawable5 = btnRegistrarNuevoUsuario.getBackground();
            buttonDrawable5 = DrawableCompat.wrap(buttonDrawable5);
            DrawableCompat.setTint(buttonDrawable5, Color.GRAY);
            btnRegistrarNuevoUsuario.setBackground(buttonDrawable5);

            btnActualizarStockProductos.setEnabled(false);

            Drawable buttonDrawable6 = btnActualizarStockProductos.getBackground();
            buttonDrawable6 = DrawableCompat.wrap(buttonDrawable6);
            DrawableCompat.setTint(buttonDrawable6, Color.GRAY);
            btnActualizarStockProductos.setBackground(buttonDrawable6);
        }
    }

    public void logout(){
        SessionManagement sessionManagement = new SessionManagement(this);
        sessionManagement.removeSession();
        changeLoginActivity();
    }

    public void changeLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void changeRegistrarProductoActivity(){
        Intent intent = new Intent(this, RegistrarProductosActivity.class);
        startActivity(intent);
    }

    public void changeBuscarProductoActivity(){
        Intent intent = new Intent(this, BuscarProductoActivity.class);
        startActivity(intent);
    }

    public void changeModificarProductoActivity(){
        Intent intent = new Intent(this, ListarModificarProductoActivity.class);
        startActivity(intent);
    }

    public void changeConsultarStockProductoActivity(){
        Intent intent = new Intent(this, ConsultarStockActivity.class);
        startActivity(intent);
    }

    public void changeModificarStockProductoActivity(){
        Intent intent = new Intent(this, ListarModificarStockProductoActivity.class);
        startActivity(intent);
    }

    public void changeRegistrarNuevoUsuarioActivity(){
        Intent intent = new Intent(this, RegistrarUsuarioActivity.class);
        startActivity(intent);
    }

    public void changeRegistrarProveedorActivity(){
        Intent intent = new Intent(this, RegistrarProveedorActivity.class);
        startActivity(intent);
    }

    public void changeModificarProveedorActivity(){
        Intent intent = new Intent(this, ListarModificarProveedorActivity.class);
        startActivity(intent);
    }

    public void changeReporteProductoActivity(){
        Intent intent = new Intent(this, ReporteProductoActivity.class);
        startActivity(intent);
    }
}