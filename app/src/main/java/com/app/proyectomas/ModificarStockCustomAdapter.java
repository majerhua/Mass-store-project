package com.app.proyectomas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.proyectomas.entity.Producto;

import java.util.List;

public class ModificarStockCustomAdapter extends ConsultarStockCustomAdapter{

    TextView txtCodigo;
    TextView txtStock;
    Button btnModificarStock;

    List<Producto> list;
    Context context;


    public ModificarStockCustomAdapter(@NonNull Context context, int resource , List<Producto> list) {
        super(context, resource,list);
        this.list = list;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item_modificar_stock,parent,false);
        Producto producto = list.get(position);

        txtCodigo = v.findViewById(R.id.txtCodigo);
        txtStock = v.findViewById(R.id.txtEmpresa);
        btnModificarStock = v.findViewById(R.id.btnModificarStock);

        txtCodigo.setText(producto.getCodigo());
        txtStock.setText(String.valueOf(producto.getStock()));

        btnModificarStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeModificarProductoActivity(list.get(position).getId());
            }
        });

        return v;
    }

    public void changeModificarProductoActivity(int productoId){

        Intent intent = new Intent(context, ModificarStockProductoActivity.class);
        Bundle b = new Bundle();
        b.putInt("productoId", productoId); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        context.startActivity(intent);
    }

    public void updateChanged(){
        this.notifyDataSetChanged();
    }

}
