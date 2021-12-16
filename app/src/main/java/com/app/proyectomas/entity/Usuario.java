package com.app.proyectomas.entity;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String nombre;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private int rol;

    public Usuario(){}

    public Usuario(String username, String password,int rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(int id, String username, String password, int rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String nombre, String dni, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Usuario(int id, String username, String password, String nombre, String dni, String correo, String telefono, String direccion) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
