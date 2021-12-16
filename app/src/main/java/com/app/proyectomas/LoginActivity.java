package com.app.proyectomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.proyectomas.entity.Usuario;
import com.app.proyectomas.local.Usuario.SessionManagement;
import com.app.proyectomas.local.Usuario.UsuarioSQLiteManager;

public class LoginActivity extends AppCompatActivity {

    UsuarioSQLiteManager usuarioSQLiteManager;

    EditText editTxtUsername;
    EditText editTxtPassword;

    Button btnIngresar;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioSQLiteManager = new UsuarioSQLiteManager(this);

        try{
            usuarioSQLiteManager.save(new Usuario("supervisor","123",0));
            usuarioSQLiteManager.save(new Usuario("vendedor","123",1));
            usuarioSQLiteManager.save(new Usuario("admin","123",2));
        }catch (Exception e){
            System.out.println("Usuario ya existe");
        }

        editTxtUsername = findViewById(R.id.editTxtUsername);
        editTxtPassword = findViewById(R.id.editTxtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
    }

    public void exit(){
        finish();
    }

    public void login(){
        Usuario usuario;
        if(editTxtUsername.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO USERNAME ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else if(editTxtPassword.getText().toString().equals("")){
            Toast.makeText(this,"EL CAMPO PASSWORD ESTÁ VACIO.",Toast.LENGTH_SHORT).show();
        }else{
            usuario = usuarioSQLiteManager.getUsuarioByUsernameAndPassword(editTxtUsername.getText().toString(),editTxtPassword.getText().toString());
            if(usuario != null){
                SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
                sessionManagement.saveSession(usuario);
                changeActivity();
            }else{
                Toast.makeText(LoginActivity.this,"USUARIO O PASSWORD INCORRECTO",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void changeActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();
        checkSession();
    }

    private void checkSession(){
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        int userId = sessionManagement.getSession();
        if(userId != -1){
            changeActivity();
        }
    }

}