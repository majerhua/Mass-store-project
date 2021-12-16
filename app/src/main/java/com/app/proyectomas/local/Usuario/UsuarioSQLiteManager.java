package com.app.proyectomas.local.Usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.proyectomas.entity.Usuario;
import com.app.proyectomas.local.ConexionSQLiteHelper;
import com.app.proyectomas.local.Producto.PersistenceProducto;

public class UsuarioSQLiteManager {

    private SQLiteDatabase db;
    ConexionSQLiteHelper conn;
    Context context;

    public UsuarioSQLiteManager(Context context){
        this.context = context;
        conn = new ConexionSQLiteHelper(context,"bd_qr",null,
                1);
    }

    public void save(Usuario usuario){

        db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_USERNAME,usuario.getUsername());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_PASSWORD,usuario.getPassword());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_NOMBRE,usuario.getNombre());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_DNI,usuario.getDni());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_CORREO,usuario.getCorreo());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_TELEFONO,usuario.getTelefono());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_DIRECCION,usuario.getDireccion());
        values.put(PersistenceUsuario.UsuarioEntry.CAMPO_ROL,usuario.getRol());

        db.insert(PersistenceUsuario.UsuarioEntry.TABLE_USUARIO,null,
                values);
    }

    public Usuario getUsuarioById(int id){

        Usuario usuario = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "username, " +
                "password, " +
                "rol " +
                "FROM Usuario WHERE id="+id,null);

        while(cursor.moveToNext()){

            usuario = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    Integer.parseInt(cursor.getString(3))
            );
        }

        return usuario;
    }

    public Usuario getUsuarioByUsernameAndPassword(String username,String password){

        Usuario usuario = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "username, " +
                "password, " +
                "rol " +
                "FROM Usuario WHERE username='"+username+"' AND password='"+password+"'",null);

        while(cursor.moveToNext()){

            usuario = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    Integer.parseInt(cursor.getString(3))
            );
        }

        return usuario;
    }
}
