package com.example.eventosapp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eventosapp.Holders.EventoHolder;
import com.example.eventosapp.Items.Item_evento;

import java.util.List;

public class EventoAdaptador extends RecyclerView.Adapter<EventoHolder >  {

    LayoutInflater inflater;
    List<Item_evento> data;
    Context context;
    int layout;
    private View.OnClickListener listener;

    public EventoAdaptador(Context context, int layout, List<Item_evento> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        this.layout = layout;

    }

    @NonNull
    @Override
    public EventoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(layout, parent, false);
        // v.setOnClickListener(this);
        return new EventoHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoHolder holder, int position) {
        holder.txt_evento.setText(data.get(position).getNombre());
        Glide.with(context).load(data.get(position).getImagen()).into(holder.imagen_evento);
    }

    @Override
    public int getItemCount() { return data.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener =listener;
    }
}
