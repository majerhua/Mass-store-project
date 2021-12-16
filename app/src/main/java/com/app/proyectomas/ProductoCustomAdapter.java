package com.app.proyectomas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.proyectomas.entity.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductoCustomAdapter extends ArrayAdapter<Producto> {

    TextView txtNombre;
    TextView txtMarca;
    TextView txtCategoria;
    TextView txtPrecio;

    List<Producto> list;
    Context context;


    public ProductoCustomAdapter(@NonNull Context context, int resource , List<Producto> list) {
        super(context, resource,list);
        this.list = list;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item_producto,parent,false);
        Producto producto = list.get(position);

        TextView txtCodigo = v.findViewById(R.id.txtCodigo);
        TextView txtMarca = v.findViewById(R.id.txtEmpresa);
        TextView txtCategoria = v.findViewById(R.id.txtTelefono);
        TextView txtPrecio = v.findViewById(R.id.txtDireccion);
        TextView txtFVencimiento = v.findViewById(R.id.txtFVencimiento);

        txtCodigo.setText(producto.getCodigo());
        txtMarca.setText((producto.getMarca()));
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtFVencimiento.setText(producto.getFechaVencimiento());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formato.parse(producto.getFechaVencimiento());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date fechaActual = new Date();
        int days = daysBetween(fechaActual,fecha);

        if(days > 10){
            v.setBackgroundColor(Color.GREEN);
        }else if(days >= 5){
            v.setBackgroundColor(Color.YELLOW);
        }else{
            v.setBackgroundColor(Color.RED);
        }

        return v;
    }

    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public void updateChanged(){
        this.notifyDataSetChanged();
    }
}
