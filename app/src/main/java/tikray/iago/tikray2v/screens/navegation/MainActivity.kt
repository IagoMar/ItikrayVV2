package tikray.iago.tikray2v.screens.navegation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tikray.iago.tikray2v.screens.ui.theme.Tikray2VTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}


// Para navegar navController.navigate(route = Screen.Register.route)