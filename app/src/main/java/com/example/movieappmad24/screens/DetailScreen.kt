@file:Suppress("DEPRECATION")

package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.movieappmad24.reusableItems.AppBars
import com.example.movieappmad24.models.Movie
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage
import com.example.movieappmad24.models.getMovie
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.reusableItems.MovieItems
import com.example.movieappmad24.mediaPlayer.MediaPlayer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(movieId: String?, navController: NavController, moviesViewModel: MoviesViewModel) {
    val AppBar = AppBars()
    val movie: Movie? = getMovie(movieId)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                movie?.let { AppBar.TopAppBar(it.title, true, navController) }
            }
        ) {
            DetailStructure(movieId, moviesViewModel)
        }
    }
}
@Composable
fun DetailStructure(movieId: String?, moviesViewModel: MoviesViewModel) {
    val movie: Movie? = moviesViewModel.getMovieId(movieId!!)
    val movieItems = MovieItems()
    val player = MediaPlayer()
    Column(
        modifier = Modifier
            .padding(
                top = 80.dp,
                bottom = 5.dp
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        movieItems.MovieCard(
            movie = movie!!,
            onItemClick = {},
            onFavClick = { moviesViewModel.toggleFavoriteAttribute(movie.id) })
        player.Player()
        LazyRow {
            items(movie.images) { image ->
                Box(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            end = 5.dp,
                            top = 10.dp
                        )
                        .size(300.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                end = 5.dp,
                                top = 10.dp
                            )
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 8.dp,
                                    topStart = 8.dp,
                                    bottomEnd = 8.dp,
                                    bottomStart = 8.dp
                                )
                            ),
                        model = image, contentDescription = "movieImage",
                    )
                }
            }
        }
    }
}