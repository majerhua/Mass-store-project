package com.app.proyectomas.local.Proveedor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.entity.Proveedor;
import com.app.proyectomas.entity.Usuario;
import com.app.proyectomas.local.ConexionSQLiteHelper;
import com.app.proyectomas.local.Producto.PersistenceProducto;
import com.app.proyectomas.local.Usuario.PersistenceUsuario;

import java.util.ArrayList;
import java.util.List;

public class ProveedorSQLiteManager {

    private SQLiteDatabase db;
    ConexionSQLiteHelper conn;
    Context context;

    public ProveedorSQLiteManager(Context context){
        this.context = context;
        conn = new ConexionSQLiteHelper(context,"bd_qr",null,
                1);
    }

    public void save(Proveedor proveedor){

        db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_CODIGO,proveedor.getCodigo());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_EMPRESA,proveedor.getEmpresa());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_TELEFONO,proveedor.getTelefono());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_DIRECCION,proveedor.getDireccion());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_RUBRO,proveedor.getRubro());

        db.insert(PersistenceProveedor.ProveedorEntry.TABLE_PROVEEDOR,null,
                values);
    }

    public List<Proveedor> getAll(){

        List<Proveedor> list = new ArrayList<>();
        Proveedor proveedor = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "empresa, " +
                "telefono, " +
                "direccion, " +
                "rubro " +
                "FROM Proveedor",null);

        while(cursor.moveToNext()){

            proveedor = new Proveedor(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );

            list.add(proveedor);
        }

        return list;
    }

    public List<Proveedor> getAllByCodigo(String codigo){

        List<Proveedor> list = new ArrayList<>();
        Proveedor proveedor = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "empresa, " +
                "telefono, " +
                "direccion, " +
                "rubro " +
                "FROM Proveedor WHERE codigo LIKE '%"+codigo+"'",null);

        while(cursor.moveToNext()){

            proveedor = new Proveedor(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );

            list.add(proveedor);
        }

        return list;
    }

    public void update(Proveedor proveedor){

        ContentValues values = new ContentValues();
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_CODIGO,proveedor.getCodigo());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_EMPRESA,proveedor.getEmpresa());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_TELEFONO,proveedor.getTelefono());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_DIRECCION,proveedor.getDireccion());
        values.put(PersistenceProveedor.ProveedorEntry.CAMPO_RUBRO,proveedor.getRubro());

        db.update(PersistenceProveedor.ProveedorEntry.TABLE_PROVEEDOR,values,
                PersistenceProducto.ProductoEntry.CAMPO_ID+" = ?",
                new String[]{String.valueOf(proveedor.getId())});

    }

    public Proveedor getById(int id){

        Proveedor proveedor = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "empresa, " +
                "telefono, " +
                "direccion, " +
                "rubro " +
                "FROM Proveedor WHERE id="+id,null);

        while(cursor.moveToNext()){

            proveedor = new Proveedor(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
        }

        return proveedor;
    }
}
