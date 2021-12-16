package com.app.proyectomas.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.proyectomas.local.Producto.PersistenceProducto;
import com.app.proyectomas.local.Proveedor.PersistenceProveedor;
import com.app.proyectomas.local.Usuario.PersistenceUsuario;

public class ConexionSQLiteHelper  extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                                int version){
        super(context,name,factory,version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(PersistenceProducto.ProductoEntry.CREAR_TABLE_PRODUCTO);
        db.execSQL(PersistenceUsuario.UsuarioEntry.CREAR_TABLE_USUARIO);
        db.execSQL(PersistenceProveedor.ProveedorEntry.CREAR_TABLE_PROVEEDOR);
    }

    public void onUpgrade(SQLiteDatabase db, int prevVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+PersistenceProducto.ProductoEntry.TABLE_PRODUCTO);
        db.execSQL("DROP TABLE IF EXISTS "+PersistenceUsuario.UsuarioEntry.TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+PersistenceProveedor.ProveedorEntry.TABLE_PROVEEDOR);
        onCreate(db);
    }
}
