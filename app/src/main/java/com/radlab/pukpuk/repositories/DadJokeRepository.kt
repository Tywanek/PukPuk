package com.radlab.pukpuk.repositories


import com.radlab.pukpuk.network.JokeApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DadJokeRepository {

    private val BASE_URL = "https://official-joke-api.appspot.com/"
    private val apiService: JokeApiService

    init {
        val retrofit = createRetrofit()
        apiService = retrofit.create(JokeApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun fetchRandomJoke(
        onSuccess: (String) -> Unit,
        onError: (Throwable) -> Unit
    ): Disposable {
        return apiService.randomJokeRx
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { joke -> "${joke.setup}\n${joke.punchline}" }
            .subscribe(
                { jokeText -> onSuccess(jokeText) },
                { error -> onError(error) }
            )
    }
}




