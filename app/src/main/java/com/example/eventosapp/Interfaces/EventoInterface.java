package com.example.eventosapp.Interfaces;

import com.example.eventosapp.Items.Item_evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface EventoInterface {
    @GET("Categorias/mostrar")
    Call<List<Item_evento>> ListarEventos();
}
