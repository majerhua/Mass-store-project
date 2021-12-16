package com.app.proyectomas.entity;

public class Proveedor {
    private int id;
    private String codigo;
    private String empresa;
    private String telefono;
    private String direccion;
    private String rubro;

    public Proveedor(int id, String codigo, String empresa, String telefono, String direccion, String rubro) {
        this.id = id;
        this.codigo = codigo;
        this.empresa = empresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rubro = rubro;
    }

    public Proveedor(String codigo, String empresa, String telefono, String direccion, String rubro) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rubro = rubro;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
}
