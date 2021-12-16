package com.app.proyectomas.local.Usuario;

public class PersistenceUsuario {
    public static abstract class UsuarioEntry{

        public static final String TABLE_USUARIO= "Usuario";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_USERNAME = "username";
        public static final String CAMPO_PASSWORD = "password";
        public static final String CAMPO_NOMBRE = "nombre";
        public static final String CAMPO_DNI = "dni";
        public static final String CAMPO_CORREO = "correo";
        public static final String CAMPO_TELEFONO = "telefono";
        public static final String CAMPO_DIRECCION = "direccion";
        public static final String CAMPO_ROL = "rol";

        public static final String CREAR_TABLE_USUARIO = "CREATE TABLE "+TABLE_USUARIO+" ("+
                CAMPO_ID+" " + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+CAMPO_USERNAME+" TEXT NOT NULL UNIQUE, " +
                ""+CAMPO_PASSWORD+" TEXT NOT NULL, " +
                ""+CAMPO_NOMBRE+" TEXT, " +
                ""+CAMPO_DNI+" TEXT, " +
                ""+CAMPO_CORREO+" TEXT, " +
                ""+CAMPO_TELEFONO+" TEXT, " +
                ""+CAMPO_DIRECCION+" TEXT, " +
                ""+CAMPO_ROL+" INTEGER DEFAULT 0 " +
                ")";
    }
}
