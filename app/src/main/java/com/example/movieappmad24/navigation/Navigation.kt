import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.navigation.DETAIL_ARGUMENT_KEY
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    val moviesViewModel: MoviesViewModel = viewModel()

    NavHost(navController = navController, // pass the NavController to NavHost
        startDestination = Screen.Home.route) {  // pass a start destination
        composable(route = Screen.Home.route){   // route with name "homescreen" navigates to HomeScreen composable
            HomeScreen(navController = navController, moviesViewModel)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = DETAIL_ARGUMENT_KEY) {type = NavType.StringType})
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                movieId = backStackEntry.arguments?.getString(DETAIL_ARGUMENT_KEY),
                moviesViewModel = moviesViewModel
            )
        }

        composable(route = Screen.Watch.route){
            WatchlistScreen(navController = navController, moviesViewModel = moviesViewModel)
        }
    }
}

