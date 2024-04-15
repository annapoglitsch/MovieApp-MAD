package com.example.movieappmad24.movie

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class MoviesViewModel : ViewModel() {
    private val _movieList = getMovies().toMutableStateList()
    private val _favoriteList = mutableListOf<Movie>()

    val movieList: List<Movie>
        get() = _movieList
    val isFavoriteList : List<Movie>
        get() = _favoriteList

    fun toggleFavoriteAttribute(movie: Movie){
        if (movie.isfavorite){
            _favoriteList.add(movie)
        } else {
            _favoriteList.remove(movie)
        }
    }
}