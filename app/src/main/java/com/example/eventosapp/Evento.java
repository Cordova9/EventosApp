package com.example.eventosapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.eventosapp.Adaptadores.EventoAdaptador;
import com.example.eventosapp.Holders.EventoHolder;
import com.example.eventosapp.Interfaces.EventoInterface;
import com.example.eventosapp.Items.Item_evento;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Evento extends Fragment {
    TextView textView;
    RecyclerView recycler_evento;
    List<Item_evento> eventos_data;
    SearchView search;
    EventoAdaptador adapter;

    public Evento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_evento, container, false);
        textView = v.findViewById(R.id.textView);
        search = v.findViewById(R.id.search);
        recycler_evento = v.findViewById(R.id.recycler_eventos);


        //PasarServicios();
        CargarPokedex();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                List<Item_evento> a = new ArrayList<>();
                for (Item_evento eventos : eventos_data) {
                    if (eventos.nombre.toLowerCase().contains(newText)) {
                        a.add(eventos);
                    }
                }
                EventoAdaptador adaptador = new EventoAdaptador(getContext(), R.layout.item_evento, a);
                recycler_evento.setAdapter(adaptador);
                recycler_evento.setLayoutManager(new LinearLayoutManager(getContext()));
                return false;
            }
        });

        return v;

    }

    void CargarPokedex() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.9.8/amddigitalcrm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventoInterface servicios = retrofit.create(EventoInterface.class);
        Call<List<Item_evento>> call = servicios.ListarEventos();

        call.enqueue(new Callback<List<Item_evento>>() {
            @Override
            public void onResponse(Call<List<Item_evento>> call, Response<List<Item_evento>> response) {
                Log.e("Eventos", response.body() + "");
                switch (response.code()) {
                    case 200:
                        List<Item_evento> item_evento = response.body();//aqui itero--el cuerpo de la respuesta es el objeto que quiero utilizar
                        eventos_data = item_evento;
                        EventoAdaptador eventosAdaptador =
                                new EventoAdaptador(getContext(), R.layout.item_evento, item_evento);
                        recycler_evento.setAdapter(eventosAdaptador);
                        recycler_evento.setLayoutManager(new LinearLayoutManager(getContext()));
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Item_evento>> call, Throwable t) {
                Log.e("Error", t.toString());

            }
        });

    }
    /*void PasarServicios(){
        adapter = new EventoAdaptador(getContext(),R.layout.item_evento,eventos_data);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Servicios.class0);
                intent.putExtra("eventos",eventos_data.get(recycler_evento.getChildAdapterPosition(v)).getId());
                startActivity(intent,1);
            }
        });

    }*/
}


