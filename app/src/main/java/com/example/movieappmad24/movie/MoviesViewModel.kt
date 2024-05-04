package com.example.movieappmad24.movie

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MoviesViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movieList = MutableStateFlow(listOf<Movie>())
    val movies: StateFlow<List<Movie>> = _movieList.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllMovies().distinctUntilChanged()
                .collect{ listOfMovies -> _movieList.value = listOfMovies }
        }
    }
    }
//bei get movieId hat mir manu geholfen -> hab nicht gepackt woran es lag (detailscreen hat kein herz gefüllt)
