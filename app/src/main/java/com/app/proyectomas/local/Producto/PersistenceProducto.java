package com.app.proyectomas.local.Producto;

public class PersistenceProducto {
    public static abstract class ProductoEntry{

        public static final String TABLE_PRODUCTO= "Producto";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_CODIGO = "codigo";
        public static final String CAMPO_MARCA = "marca";
        public static final String CAMPO_CATEGORIA = "categoria";
        public static final String CAMPO_PRECIO = "precio";
        public static final String CAMPO_STOCK = "stock";
        public static final String CAMPO_FECHA_VENCIMIENTO = "fecha_vencimiento";

        public static final String CREAR_TABLE_PRODUCTO = "CREATE TABLE "+TABLE_PRODUCTO+" ("+
                CAMPO_ID+" " + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+CAMPO_CODIGO+" TEXT NOT NULL, " +
                ""+CAMPO_MARCA+" TEXT NOT NULL, " +
                ""+CAMPO_CATEGORIA+" TEXT NOT NULL, " +
                ""+CAMPO_PRECIO+" REAL NOT NULL, " +
                ""+CAMPO_STOCK+" INTEGER DEFAULT 0, " +
                ""+CAMPO_FECHA_VENCIMIENTO+" TEXT"+
                ")";
    }
}
