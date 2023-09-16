package com.radlab.pukpuk.repositories

import com.radlab.pukpuk.network.ChuckApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChuckJokeRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ChuckApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val chuckJokeApiService: ChuckApiService = retrofit.create(ChuckApiService::class.java)
    suspend fun getRandomJoke() = chuckJokeApiService.randomJoke()
}
