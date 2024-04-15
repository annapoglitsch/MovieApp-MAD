package com.example.movieappmad24.movie

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import kotlinx.coroutines.flow.StateFlow

class MoviesViewModel : ViewModel() {
    private val _movieList = getMovies().toMutableStateList()

    val movieList: List<Movie>
        get() = _movieList
    val isFavoriteList : List<Movie>
        get() = _movieList.filter { movie -> movie.isfavorite }

    fun toggleFavoriteAttribute(movieId: String) = _movieList.find { it.id == movieId }?.let { movie ->
        movie.isfavorite = !movie.isfavorite
    }
}