package tikray.iago.tikray2v.screens.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tikray.iago.tikray2v.screens.RegisterScreenUi
import tikray.iago.tikray2v.screens.ScreenStart

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route

    ) {
        composable(
            route = Screen.Home.route
        ) {
            ScreenStart(navController = rememberNavController())
        }

        composable(
            route = Screen.Register.route
        ) {
            RegisterScreenUi()
        }
    }
}
