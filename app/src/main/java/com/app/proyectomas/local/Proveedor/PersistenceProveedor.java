package com.app.proyectomas.local.Proveedor;

public class PersistenceProveedor {
    public static abstract class ProveedorEntry{

        public static final String TABLE_PROVEEDOR = "Proveedor";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_CODIGO = "codigo";
        public static final String CAMPO_EMPRESA = "empresa";
        public static final String CAMPO_TELEFONO = "telefono";
        public static final String CAMPO_DIRECCION = "direccion";
        public static final String CAMPO_RUBRO = "rubro";

        public static final String CREAR_TABLE_PROVEEDOR = "CREATE TABLE "+TABLE_PROVEEDOR+" ("+
                CAMPO_ID+" " + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+CAMPO_CODIGO+" TEXT NOT NULL, " +
                ""+CAMPO_EMPRESA+" TEXT NOT NULL, " +
                ""+CAMPO_TELEFONO+" TEXT, " +
                ""+CAMPO_DIRECCION+" TEXT, " +
                ""+CAMPO_RUBRO+" TEXT " +
                ")";
    }
}
