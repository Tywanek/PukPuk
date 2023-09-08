package com.radlab.pukpuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PukPukTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RandomJokeScreen(viewModel = JokeFlowViewModel(RandomJokeRepository()))
                }
            }
        }
    }
}

@Composable
fun RandomJokeScreen(viewModel: JokeFlowViewModel) {
    var text by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        viewModel.getRandomJoke().collect { joke ->
            text = joke
        }
    }
    Text(text = text, modifier = Modifier.padding(16.dp))
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PukPukTheme {
        Greeting("Android")
    }
}