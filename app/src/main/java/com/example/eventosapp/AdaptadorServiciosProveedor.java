package com.example.eventosapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorServiciosProveedor extends RecyclerView.Adapter<AdaptadorServiciosProveedor.ViewHolderDatos> {

    ArrayList<String> Datos;

    public AdaptadorServiciosProveedor(ArrayList<String> datos) {
        Datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.servicio_proveedor_informacion,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(Datos.get(position));
    }

    @Override
    public int getItemCount() {
        return Datos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView cantidad;
        TextView descripcion;
        ImageView logo;
        ImageButton favorito;
        ImageButton agregar;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_titulo_servicios);
            cantidad = itemView.findViewById(R.id.txt_cant_servicios);
            descripcion = itemView.findViewById(R.id.txt_servicio_descripcion);
            logo = itemView.findViewById(R.id.img_logo);
            favorito = itemView.findViewById(R.id.imgb_favorito);
            agregar = itemView.findViewById(R.id.imgb_agregar);

        }

        public void asignarDatos(String dato) {
            titulo.setText(dato);
            cantidad.setText(dato);
            descripcion.setText(dato);

        }
    }
}


