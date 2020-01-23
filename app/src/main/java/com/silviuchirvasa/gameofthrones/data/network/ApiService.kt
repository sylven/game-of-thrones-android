package com.silviuchirvasa.gameofthrones.data.network

import com.silviuchirvasa.gameofthrones.data.network.model.NetworkCharacter
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("show/characters")
    fun getCharacters(): Call<List<NetworkCharacter>>

}