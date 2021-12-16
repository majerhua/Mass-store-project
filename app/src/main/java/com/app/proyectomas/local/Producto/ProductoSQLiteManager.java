package com.app.proyectomas.local.Producto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.local.ConexionSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductoSQLiteManager {

    private SQLiteDatabase db;
    ConexionSQLiteHelper conn;
    Context context;

    public ProductoSQLiteManager(Context context){
        this.context = context;
        conn = new ConexionSQLiteHelper(context,"bd_qr",null,
                1);
    }


    public void save(Producto producto){

        db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PersistenceProducto.ProductoEntry.CAMPO_CODIGO,producto.getCodigo());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_MARCA,producto.getMarca());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_CATEGORIA,producto.getCategoria());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_PRECIO,producto.getPrecio());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_FECHA_VENCIMIENTO,producto.getFechaVencimiento());

        db.insert(PersistenceProducto.ProductoEntry.TABLE_PRODUCTO,null,
                values);
    }

    public List<Producto> getAll(){

        List<Producto> list = new ArrayList<>();
        Producto producto = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "marca, " +
                "categoria, " +
                "precio, " +
                "stock, " +
                "fecha_vencimiento " +
                "FROM Producto",null);

        while(cursor.moveToNext()){

            producto = new Producto(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Double.parseDouble(cursor.getString(4)),
                    Integer.parseInt(cursor.getString(5)),
                    cursor.getString(6)
            );

            list.add(producto);
        }

        return list;
    }

    public Producto getById(int id){

        Producto producto = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "marca, " +
                "categoria, " +
                "precio, " +
                "stock, " +
                "fecha_vencimiento " +
                "FROM Producto WHERE id="+id,null);

        while(cursor.moveToNext()){

            producto = new Producto(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Double.parseDouble(cursor.getString(4)),
                    Integer.parseInt(cursor.getString(5)),
                    cursor.getString(6)
            );
        }

        return producto;
    }

    public List<Producto> getAllByCodigo(String codigo){

        List<Producto> list = new ArrayList<>();
        Producto producto = null;

        db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" " +
                "SELECT id, " +
                "codigo, " +
                "marca, " +
                "categoria, " +
                "precio, " +
                "stock, " +
                "fecha_vencimiento " +
                "FROM Producto WHERE codigo LIKE '%"+codigo+"%'",null);

        while(cursor.moveToNext()){

            producto = new Producto(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Double.parseDouble(cursor.getString(4)),
                    Integer.parseInt(cursor.getString(5)),
                    cursor.getString(6)
            );

            list.add(producto);
        }

        return list;
    }

    public void update(Producto producto){

        ContentValues values = new ContentValues();
        values.put(PersistenceProducto.ProductoEntry.CAMPO_CODIGO,producto.getCodigo());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_MARCA,producto.getMarca());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_CATEGORIA,producto.getCategoria());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_PRECIO,producto.getPrecio());
        values.put(PersistenceProducto.ProductoEntry.CAMPO_FECHA_VENCIMIENTO,producto.getFechaVencimiento());

        db.update(PersistenceProducto.ProductoEntry.TABLE_PRODUCTO,values,
                PersistenceProducto.ProductoEntry.CAMPO_ID+" = ?",
                new String[]{String.valueOf(producto.getId())});

    }

    public void updateStock(Producto producto){

        ContentValues values = new ContentValues();
        values.put(PersistenceProducto.ProductoEntry.CAMPO_STOCK,producto.getStock());

        db.update(PersistenceProducto.ProductoEntry.TABLE_PRODUCTO,values,
                PersistenceProducto.ProductoEntry.CAMPO_ID+" = ?",
                new String[]{String.valueOf(producto.getId())});

    }

}
