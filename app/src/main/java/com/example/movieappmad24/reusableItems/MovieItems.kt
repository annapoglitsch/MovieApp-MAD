package com.example.movieappmad24.reusableItems

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.R
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.movie.MoviesViewModel


class MovieItems {
    @Composable
    fun MovieCard(
        movie: Movie,
        onItemClick: (String) -> Unit = {},
        onFavClick: (String) -> Unit = {},
    ) {
        var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .height(if (expanded) 380.dp else 180.dp)
                .width(350.dp)
                .background(Color.White)
                .clickable { onItemClick(movie.id) },
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .width(350.dp)
                        .height(150.dp)
                )
                {
                    AsyncImage(
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                top = 10.dp,
                                end = 10.dp,
                                bottom = 2.dp,
                            )
                            .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                        contentScale = ContentScale.Crop,
                        model = movie.images[0],
                        contentDescription = "movie_image"
                    )
                    Box() {
                        IconButton(
                            onClick = { onFavClick(movie.id) },
                            modifier = Modifier.padding(
                                top = 15.dp,
                                start = 300.dp,
                            ),
                        ) {
                            Icon(
                                modifier = Modifier.clickable {
                                    onFavClick(movie.id) },
                                tint = MaterialTheme.colorScheme.primary,
                                imageVector =
                                if (movie.isfavorite) {
                                    Icons.Filled.Favorite
                                } else {
                                    Icons.Default.FavoriteBorder
                                },
                                contentDescription = "Add Favorites")
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .animateContentSize()
                        .width(350.dp)
                        .height(30.dp)
                        .padding(
                            start = 10.dp,
                        ),
                ) {
                    Text(
                        text = movie.title, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { expanded = !expanded },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = if (expanded) R.drawable.baseline_keyboard_arrow_down_24 else R.drawable.baseline_keyboard_arrow_up_24),
                            contentDescription = null
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .width(350.dp)
                        .padding(
                            start = 10.dp,
                        ),
                ) {
                    if (expanded) {
                        MovieText(movie)
                    }
                }
            }
        }
    }

    @Composable
    fun MovieText(movie: Movie) {
        Text(text = "Director: ${movie.director}")
        Text(text = "Released: ${movie.year}")
        Text(text = "Genre: ${movie.genre}")
        Text(text = "Actors: ${movie.actors}")
        Text(text = "Rating: ${movie.rating}")
        Divider(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .width(100.dp),
            thickness = 1.dp,
            color = Color.Black
        )
        Text(text = "Plot: " + movie.plot)
    }

    @Composable
    fun MovieList(
        movieList: List<Movie>,
        navController: NavController,
        moviesViewModel: MoviesViewModel
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                top = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movieList) { movie ->
                MovieCard(
                    movie,
                    onItemClick = { id -> navController.navigate("detailScreen/$id") },
                    onFavClick = { moviesViewModel.toggleFavoriteAttribute(movie.id) })
            }
        }
    }
}