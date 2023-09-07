package com.radlab.pukpuk.network

import com.radlab.pukpuk.models.DadJokeDto
import io.reactivex.Observable
import retrofit2.http.GET

interface JokeApiService {
    companion object {
         const val BASE_URL = "https://official-joke-api.appspot.com/"
    }
    @get:GET("random_joke")
    val randomJokeRx: Observable<DadJokeDto>

    @GET("random_joke")
    suspend fun randomJoke(): DadJokeDto
}
