package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    val AppBar = AppBars()
    val MovieCard = MovieCard()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme

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
                                )
                                .statusBarsPadding(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            MovieList(movieList = getMovies())
                        }
                     }
                }
            }
        }
    }
    /*MovieList: https://www.geeksforgeeks.org/android-jetpack-compose-create-a-movie-app/
    https://developer.android.com/jetpack/compose/lists */
    @Composable
    fun MovieList(movieList: List<Movie> = getMovies()) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movieList) { movie ->
                MovieCard.MovieRow(movie)
            }
        }

    }
}