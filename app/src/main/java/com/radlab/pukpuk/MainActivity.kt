package com.radlab.pukpuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radlab.pukpuk.repositories.RandomJokeRepository
import com.radlab.pukpuk.ui.theme.PukPukTheme
import com.radlab.pukpuk.viewmodels.JokeFlowViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PukPukTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlowlyAppearingText(viewModel = JokeFlowViewModel(RandomJokeRepository()))
                }
            }
        }
    }
}

@Composable
fun SlowlyAppearingText(viewModel: JokeFlowViewModel, durationMillis: Int = 2000) {
    var text by remember { mutableStateOf("") }
    var visibleText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.getRandomJoke().collect { joke ->
            text = joke
            for (i in joke.indices) {
                visibleText = joke.substring(0, i + 1)
                delay(durationMillis.toLong() / joke.length)
            }
        }
    }

    Column {
        Text(
            text = visibleText, modifier = Modifier
                .padding(25.dp)
                .padding(top = 36.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PukPukTheme {
        SlowlyAppearingText(viewModel = JokeFlowViewModel(RandomJokeRepository()))
    }
}