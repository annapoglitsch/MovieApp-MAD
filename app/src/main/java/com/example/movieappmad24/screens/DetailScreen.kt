package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.AppBars
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovieById

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    val AppBar = AppBars()
    val movie: Movie? = getMovieById(movieId)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                AppBar.TopAppBarCurrent(movie = movie, navController)
            }
        ) {
            DetailStructure(movieId)
        }
    }
}


@Composable
fun DetailStructure(movieId: String?) {
    val movie: Movie? = getMovieById(movieId)
    Column(
       // modifier = Modifier.ce
    ) {
        MovieCard(movie = movie!!)
    }
}