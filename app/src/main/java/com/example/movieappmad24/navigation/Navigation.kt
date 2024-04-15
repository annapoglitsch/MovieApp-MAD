import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.movie.MoviesViewModel
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    val moviesViewModel = MoviesViewModel()
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen(navController, moviesViewModel)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = "movieId"){type = NavType.StringType})
        ){backStackEntry -> DetailScreen(movieId = backStackEntry.arguments?.getString("movieId"), navController, moviesViewModel)
        }
        composable(route = Screen.Watch.route){
            WatchlistScreen(navController, moviesViewModel)
        }
    }
}

