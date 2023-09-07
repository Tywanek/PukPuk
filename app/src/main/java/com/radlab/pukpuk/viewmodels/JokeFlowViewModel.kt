package com.radlab.pukpuk.viewmodels

import androidx.lifecycle.ViewModel
import com.radlab.pukpuk.models.mapToJoke
import com.radlab.pukpuk.repositories.RandomJokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeFlowViewModel : ViewModel() {
    private val jokeRepository: RandomJokeRepository by lazy {
        RandomJokeRepository()
    }

    fun getRandomJoke(): Flow<String> = flow { emit(jokeRepository.getRandomJoke()) }.mapToJoke()

}