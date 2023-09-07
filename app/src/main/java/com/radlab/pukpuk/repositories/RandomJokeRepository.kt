package com.radlab.pukpuk.repositories

import com.radlab.pukpuk.network.JokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomJokeRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(JokeApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val randomJokeApiService: JokeApiService = retrofit.create(JokeApiService::class.java)
    suspend fun getRandomJoke() = randomJokeApiService.randomJoke()

}
