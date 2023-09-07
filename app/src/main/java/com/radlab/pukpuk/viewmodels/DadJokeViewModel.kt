package com.radlab.pukpuk.viewmodels

import androidx.lifecycle.ViewModel
import com.radlab.pukpuk.repositories.DadJokeRepository
import io.reactivex.disposables.CompositeDisposable


class DadJokeViewModel : ViewModel() {
    private val dadJokeRepository: DadJokeRepository = DadJokeRepository()
    private val disposables = CompositeDisposable()

    fun fetchRandomJoke(
        onSuccess: (String) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        disposables.add(
            dadJokeRepository.fetchRandomJoke(onSuccess = onSuccess, onError = onError)
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
