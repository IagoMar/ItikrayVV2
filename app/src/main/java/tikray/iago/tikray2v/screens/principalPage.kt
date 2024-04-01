package tikray.iago.tikray2v.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import tikray.iago.tikray2v.ui.theme.Tikray2VTheme

import tikray.iago.tikray2v.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                ScreenRegister()
            }
        }
    }
}


@Composable
fun ScreenRegister() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(19, 18, 69))
    ) {

        // Valores para la colocacion de elemntos relativos
        val (logo, buttonLogin, buttonSignUp) = createRefs() // Creamos las referencias
        val topMargin = createGuidelineFromTop(0.3f) // Creamos el margen de arriba

        Image(
            painter = painterResource(id = R.drawable.logo_empresa),
            contentDescription = "logo company", modifier = Modifier.constrainAs(logo){
                top.linkTo(topMargin)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )



    }


}


@Preview(showSystemUi = true)
@Composable
fun Preview() {

    ScreenRegister()


}