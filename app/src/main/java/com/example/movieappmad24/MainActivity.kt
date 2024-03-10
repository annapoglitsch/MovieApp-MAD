package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
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
                            CenterAlignedTopAppBar(
                                modifier = Modifier.background(Color.Cyan),
                                title = { Text(text = "MovieApp") },
                            )
                        },

                        bottomBar = {
                            BottomAppBar(modifier = Modifier.background(Color.Cyan)) {
                                NavigationBarItem(
                                    label = { Text(text = "Home") },
                                    selected = true,
                                    onClick = { /*TODO*/ },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_home_24),
                                            contentDescription = null
                                        )
                                    })
                                NavigationBarItem(
                                    label = { Text(text = "Watchlist") },
                                    selected = true,
                                    onClick = { /*TODO*/ },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_star_24),
                                            contentDescription = null
                                        )
                                    })
                            }
                        },
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        bottom = 50.dp,
                                        top = 50.dp
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                                MovieList(movieList = getMovies())
                            }

                        }
                    )
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
                    MovieCard(movie)
                }
            }

    }

    @Composable
    fun MovieCard(movie: Movie) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .height(if (expanded) 380.dp else 180.dp)
                .width(350.dp)
                .background(Color.White),
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
                    Icon(
                        modifier = Modifier.padding(
                            top = 18.dp,
                            start = 310.dp,
                        ),
                        painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                        contentDescription = null
                    )
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
                    Text(text = "Director: " + movie.director)
                    Text(text = "Released: " + movie.year)
                    Text(text = "Genre: " + movie.genre)
                    Text(text = "Autors: " + movie.actors)
                    Text(text = "Rating: " + movie.rating)
                    Text(text = "Plot: " + movie.plot)
                }

            }
        }
    }
}