package com.example.movieappmad24

import Navigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import android.util.Log
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate called.")
        setContent {
            MovieAppMAD24Theme {
                Navigation()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart called.")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume called.")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause called.")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop called.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy called.")
    }
}

