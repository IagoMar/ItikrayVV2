package tikray.iago.tikray2v.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import tikray.iago.tikray2v.R
import tikray.iago.tikray2v.screens.ui.theme.Tikray2VTheme

class registerScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreenUi()

                }
            }
        }
    }
}



fun MesurerSecurityPassword() {

}



@Composable
fun RegisterScreenUi() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(19, 18, 69))
    ) {

        // Definimos las referencias para poder colocar los elementos de forma "relativa"
        val (logo, title, name, mail, password, barSecurityIndicate, textBarSecurity, confirmPassword) = createRefs()
        //Definimos el margen de arriba
        val topMargin = createGuidelineFromTop(0.08f)
        //Definimos el margen de la izquierda
        val startMargin = createGuidelineFromStart(0.10f)
        // Definimos el margen de la derecha
        val endMargin = createGuidelineFromEnd(0.20f)

        //Definimos los estados para los TextFields

        var textName by remember {
            mutableStateOf("")
        }


        var textMail by remember {
            mutableStateOf("")
        }


        var textPassword by remember {
            mutableStateOf("")
        }
        var textConfirmPassword by remember {
            mutableStateOf("")
        }

        //Creamos una cadena para unir todos los texFields y hacer que la separación sea relativa


        // Creamos una barrera para que la cadena no pise al titulo ni al logo


        //logo
        Image(
            painter = painterResource(id = R.drawable.logo_empresa),
            contentDescription = "logo company",
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(topMargin)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )

        //Titulo
        Text(
            text = "SIGN UP",
            style = TextStyle(fontSize = 45.sp, color = Color.White),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(logo.bottom, margin = 25.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })


        // TEXTFIELDS PARA EL REGISTRO

        //name
        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            label = { Text(text = "Name") },
            isError = false,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(title.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )
        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            label = { Text(text = "Mail") },
            isError = false,
            modifier = Modifier.constrainAs(mail) {
                top.linkTo(name.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )
        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            label = { Text(text = "Password") },
            isError = false,
            modifier = Modifier.constrainAs(password) {
                top.linkTo(mail.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )

        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            label = { Text(text = "Confirm Password") },
            isError = false,
            modifier = Modifier.constrainAs(confirmPassword) {
                top.linkTo(password.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )


    }


}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    RegisterScreenUi()

}