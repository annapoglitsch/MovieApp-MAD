package com.example.movieappmad24.movie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movieList = getMovies().toMutableStateList()
    val movieList: List<Movie>
        get() = _movieList
    val isFavoriteList : List<Movie>
        get() = _movieList.filter { movie -> movie.isfavorite }
    fun toggleFavoriteAttribute(movieId: String) = _movieList.find { it.id == movieId }?.let { movie ->
        movie.isfavorite = !movie.isfavorite
    }
    fun getMovieId(movieId: String): Movie? {
        return _movieList.find { it.id ==  movieId}
    }
    @Composable
    fun createMoviesViewModel(): MoviesViewModel {
        val factory = MovieViewModelFactory(repository = repository)
        return viewModel(factory = factory)
    }
}