package tikray.iago.tikray2v.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tikray.iago.tikray2v.R
import tikray.iago.tikray2v.ui.theme.Tikray2VTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ScreenStart(navController = rememberNavController())
            }
        }
        }
    }



@Composable
fun ScreenStart(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(19, 18, 69))
    ) {

        // Valores para la colocacion de elemntos relativos
        val (title, logo, buttonLogin, buttonSignUp) = createRefs() // Creamos las referencias
        val topMargin = createGuidelineFromTop(0.1f) // Creamos el margen de arriba Para el titulo
        val topMargin1 = createGuidelineFromTop(0.3f) // Creamos el margen de arriba Para el logo



        Text(
            text = "TIKRAY", modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(topMargin)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 70.sp, color = Color.White,

                )
        )

        Image(
            painter = painterResource(id = R.drawable.logo_empresa),
            contentDescription = "logo company", modifier = Modifier.constrainAs(logo) {
                top.linkTo(topMargin1)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .width(120.dp)
                .constrainAs(buttonLogin) {
                    top.linkTo(logo.bottom, margin = 75.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)


                },

            shape = CutCornerShape(3.dp)
        ) {
            Text(text = "LOGIN")

        }
        Button(
            onClick = { navController.navigate(route = "ScreenRegister") }, modifier = Modifier
                .width(120.dp)
                .constrainAs(buttonSignUp) {
                    top.linkTo(buttonLogin.bottom, margin = 5.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            shape = CutCornerShape(3.dp)
        ) {
            Text(text = "SIGN UP")

        }


    }


}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    ScreenStart(navController = rememberNavController())


}