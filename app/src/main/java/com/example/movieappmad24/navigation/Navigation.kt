import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = "movieId"){type = NavType.StringType})
        ){backStackEntry -> DetailScreen(movieId = backStackEntry.arguments?.getString("movieId"), navController)
        }
        composable(route = Screen.Watch.route){
            WatchlistScreen(navController)
        }
    }
}
//At the moment the below function is not in need of a seperate class, as it grows it might be useful to do so

sealed class Screen (val route: String) {
    data object Home: Screen(route = "homeScreen")
    data object Details: Screen(route = "detailScreen/{movieId}")
    data object Watch: Screen(route = "watchlistScreen")
}