package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.movie.WatchViewModel
import com.example.movieappmad24.reusableItems.AppBars
import com.example.movieappmad24.reusableItems.MovieItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchlistScreen(navController: NavController, watchViewModel: WatchViewModel) {
    val AppBar = AppBars()
    val movieItems = MovieItems()
    Surface {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppBar.TopAppBar("Watchlist", false, navController)
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
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val moviesViewModel = watchViewModel.createMoviesViewModel()
                movieItems.MovieList(navController = navController,
                    moviesViewModel = moviesViewModel
                )
            }
        }
    }
}
