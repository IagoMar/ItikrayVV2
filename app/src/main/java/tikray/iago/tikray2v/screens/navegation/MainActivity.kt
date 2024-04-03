package tikray.iago.tikray2v.screens.navegation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tikray.iago.tikray2v.screens.RegisterScreenUi
import tikray.iago.tikray2v.screens.ScreenStart
import tikray.iago.tikray2v.screens.ui.theme.Tikray2VTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "ScreenHomePage"){
                        composable("ScreenHomePage"){ ScreenStart(navController = navigationController)}
                        composable("ScreenRegister"){ RegisterScreenUi(navController = navigationController) }
                    }


            }
        }
    }
}


// Para navegar navController.navigate(route = Screen.Register.route)