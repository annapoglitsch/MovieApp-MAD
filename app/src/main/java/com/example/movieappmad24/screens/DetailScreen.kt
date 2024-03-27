package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.AppBars
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovieById
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage

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
        modifier = Modifier
            .padding(
                top = 80.dp,
                bottom = 5.dp
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MovieCard(movie = movie!!)
        LazyRow {
            items(movie.images) { image ->
                AsyncImage(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            end = 5.dp,
                            top = 10.dp
                        )
                      //  .size(300.dp)
                        .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp, bottomEnd = 8.dp, bottomStart = 8.dp)),
                    model = image, contentDescription = "movieImage",
                )
            }
        }
    }
}

//ToDo: paddingValues
//      imagesize down