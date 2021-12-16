package com.app.proyectomas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.proyectomas.entity.Producto;
import com.app.proyectomas.entity.Proveedor;

import java.util.List;

public class ProveedorCustomAdapter extends ArrayAdapter<Proveedor> {

    TextView txtCodigo;
    TextView txtEmpresa;
    TextView txtTelefono;
    TextView txtDireccion;
    TextView txtRubro;
    Button btnModificar;

    List<Proveedor> list;
    Context context;


    public ProveedorCustomAdapter(@NonNull Context context, int resource , List<Proveedor> list) {
        super(context, resource,list);
        this.list = list;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item_proveedor,parent,false);
        Proveedor proveedor = list.get(position);

        txtCodigo = v.findViewById(R.id.txtCodigo);
        txtEmpresa = v.findViewById(R.id.txtEmpresa);
        txtTelefono = v.findViewById(R.id.txtTelefono);
        txtDireccion = v.findViewById(R.id.txtDireccion);
        txtRubro = v.findViewById(R.id.txtRubro);
        btnModificar = v.findViewById(R.id.btnModificar);

        txtCodigo.setText(proveedor.getCodigo());
        txtEmpresa.setText((proveedor.getEmpresa()));
        txtTelefono.setText(proveedor.getTelefono());
        txtDireccion.setText(proveedor.getDireccion());
        txtRubro.setText(proveedor.getRubro());

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeModificarProductoActivity(list.get(position).getId());
            }
        });

        return v;
    }

    public void changeModificarProductoActivity(int proveedorId){

        Intent intent = new Intent(context, ModificarProveedorActivity.class);
        Bundle b = new Bundle();
        b.putInt("proveedorId", proveedorId); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        context.startActivity(intent);
    }

    public void updateChanged(){
        this.notifyDataSetChanged();
    }
}
