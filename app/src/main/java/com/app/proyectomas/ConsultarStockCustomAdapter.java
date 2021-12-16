package com.app.proyectomas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.proyectomas.entity.Producto;

import java.util.List;

public class ConsultarStockCustomAdapter extends ArrayAdapter<Producto> {

    TextView txtCodigo;
    TextView txtStock;

    List<Producto> list;
    Context context;


    public ConsultarStockCustomAdapter(@NonNull Context context, int resource , List<Producto> list) {
        super(context, resource,list);
        this.list = list;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item_consultar_stock,parent,false);
        Producto producto = list.get(position);

        txtCodigo = v.findViewById(R.id.txtCodigo);
        txtStock = v.findViewById(R.id.txtEmpresa);


        txtCodigo.setText(producto.getCodigo());
        txtStock.setText(String.valueOf(producto.getStock()));

        return v;
    }

    public void updateChanged(){
        this.notifyDataSetChanged();
    }

}
