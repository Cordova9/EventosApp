package com.example.eventosapp.Holders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventosapp.R;

public class EventoHolder extends RecyclerView.ViewHolder {
    public ImageView imagen_evento;
    public TextView txt_evento;
    public CardView cv;
    public Context context;
    public String id;


    public EventoHolder(@NonNull View itemView, final Context c) {
        super(itemView);
        imagen_evento = itemView.findViewById(R.id.imagen_evento);
        txt_evento = itemView.findViewById(R.id.txt_evento);
        this.context = c;
        cv=itemView.findViewById(R.id.card_view_eventos);



    }
}
