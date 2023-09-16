package com.radlab.pukpuk.network

import com.radlab.pukpuk.models.ChuckJokeDto
import retrofit2.http.GET

interface ChuckApiService {
    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }

    @GET("random")
    suspend fun randomJoke(): ChuckJokeDto
}