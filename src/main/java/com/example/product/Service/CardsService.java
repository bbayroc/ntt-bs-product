package com.example.product.Service;

import com.example.product.entity.CardResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CardsService {

    @GET("/card/cards/idclients/{idclient}")
    Call<CardResponse> cardrequest(@Path("idclient") String idclient);



}
