package com.example.movieappmad24

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MoviesViewModel by viewModels()
        viewModel.movieList
        setContent {
            MovieAppMAD24Theme {
                Navigation()

            }
        }
    }
}
