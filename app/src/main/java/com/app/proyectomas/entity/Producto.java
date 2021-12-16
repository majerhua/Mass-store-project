package com.app.proyectomas.entity;

public class Producto {

    public int id;
    public String codigo;
    public String marca;
    public String categoria;
    public double precio;
    public int stock;
    public String fechaVencimiento;

    public Producto(){}

    public Producto(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public Producto(String codigo, String marca, String categoria, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Producto(String codigo, String marca, String categoria, double precio, String fechaVencimiento) {
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Producto(int id, String codigo, String marca, String categoria, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Producto(int id, String codigo, String marca, String categoria, double precio, String fechaVencimiento) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Producto(int id, String codigo, String marca, String categoria, double precio, int stock) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(int id, String codigo, String marca, String categoria, double precio, int stock, String fechaVencimiento) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}
