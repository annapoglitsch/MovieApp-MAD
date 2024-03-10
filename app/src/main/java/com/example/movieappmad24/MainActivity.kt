package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    val AppBar = AppBars()
    val MovieCard = MovieCard()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            AppBar.TopAppBar()
                        },
                        bottomBar = {
                           AppBar.BottomAppBar()
                        },
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    bottom = 50.dp,
                                    top = 50.dp
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            MovieCard.MovieList()
                        }
                     }
                }
            }
        }
    }
}