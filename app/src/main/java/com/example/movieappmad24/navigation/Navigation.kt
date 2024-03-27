import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen


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
    }
}

sealed class Screen (val route: String) {
    data object Home: Screen(route = "homeScreen")
    data object Details: Screen(route = "detailScreen/{movieId}")
}