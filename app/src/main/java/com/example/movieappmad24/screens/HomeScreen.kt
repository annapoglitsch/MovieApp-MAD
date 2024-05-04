package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.movie.data.MovieDatabase
import com.example.movieappmad24.movie.data.MovieRepository
import com.example.movieappmad24.movie.MovieViewModelFactory
import com.example.movieappmad24.reusableItems.AppBars
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.reusableItems.MovieItems


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, moviesViewModel: MoviesViewModel) {
    val AppBar = AppBars()
    val movieItems = MovieItems()

    val db = MovieDatabase.getDatabase(LocalContext.current)
    val repository = MovieRepository(movieDao = db.movieDao())
    val factory = MovieViewModelFactory(repository = repository)
    val viewModel: MoviesViewModel = viewModel(factory = factory)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppBar.TopAppBar("MovieApp", false, navController)
            },
            bottomBar = {
                AppBar.BottomAppBar(navController)
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = 50.dp,
                        top = 70.dp
                        //PaddingValues
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val moviesState by viewModel.movies.collectAsState()
                movieItems.MovieList(moviesState, navController, moviesViewModel)
            }
        }
    }
}

