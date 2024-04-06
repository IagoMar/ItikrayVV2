package tikray.iago.tikray2v.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import tikray.iago.tikray2v.R
import tikray.iago.tikray2v.R.color.tikrayColor1
import tikray.iago.tikray2v.components.AlertDialogExample
import tikray.iago.tikray2v.firebase.auth.authent
import tikray.iago.tikray2v.screens.prefabricados.colorsButton
import tikray.iago.tikray2v.screens.prefabricados.colorss
import tikray.iago.tikray2v.screens.prefabricados.fieldsNotEmpty
import tikray.iago.tikray2v.screens.ui.theme.Tikray2VTheme

class RegisterScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreenUi(navController = rememberNavController())

                }
            }
        }
    }
}


@Composable
fun RegisterScreenUi(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = tikrayColor1))
    ) {

        // Definimos las referencias para poder colocar los elementos de forma "relativa"
        val (logo, title, name, mail, password, barSecurityIndicate, confirmPassword, button1, errorText, matchPassword) = createRefs()
        //Definimos el margen de arriba
        val topMargin = createGuidelineFromTop(0.08f)
        //Definimos el margen de la izquierda
        // Definimos el margen de la derecha

        //Definimos los estados para los TextFields

        var textName by remember { mutableStateOf("") }

        var textMail by remember { mutableStateOf("") }

        var colorForErrorText by remember {
            mutableStateOf(Color.Red)
        }


        var textPassword by remember { mutableStateOf("") }

        var textConfirmPassword by remember { mutableStateOf("") }

        var visibilityOnOrOff by remember { mutableStateOf(true) }

        var visibilityOnOrOff1 by remember { mutableStateOf(true) }


        val colorForTextMachPassword: Boolean =
            if (textPassword == textConfirmPassword ) false else true
        val isErrorPasswordBecauseDontMatch =
            if (textPassword == textConfirmPassword) Color.Transparent else  Color.Red

        // Variables que haran que el ojo para mostrar la contraseña cambie su icono
        val iconVisibility1 = if (visibilityOnOrOff) {
            Icons.Filled.VisibilityOff
        } else {
            Icons.Filled.Visibility
        }

        val iconVisibility2 = if (!visibilityOnOrOff1) {
            Icons.Filled.Visibility
        } else {
            Icons.Filled.VisibilityOff
        }


        //Creamos una cadena para unir todos los texFields y hacer que la separación sea relativa


        val emptyFields = fieldsNotEmpty(textName, textMail, textPassword, textConfirmPassword)
        val textError = when (emptyFields) {
            1 -> "Name field is required"
            2 -> "Mail field is required"
            3 -> "Password field is required"
            4 -> "Confirm password field is required"
            else -> ""
        }

        val emptyFieldTrueOrFalse = if(emptyFields in 1..4  || textPassword.length !in 7..1000 || textPassword != textConfirmPassword)  {
            false
        }
        else {
            true
        }


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
        //NAME
        OutlinedTextField(
            value = textName,
            onValueChange = { textName = it },
            label = { Text(text = "Name") },
            isError = false,
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(title.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            },
            colors = colorss()


        )
        //EMAIL
        OutlinedTextField(
            value = textMail,
            onValueChange = { textMail = it },
            label = { Text(text = "Mail") },
            colors = colorss(),
            isError = false,
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.constrainAs(mail) {
                top.linkTo(name.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )

        //CONSTRASENYA
        OutlinedTextField(
            value = textPassword,
            onValueChange = { textPassword = it },
            label = { Text(text = "Password") },
            isError = false,
            colors = colorss(),
            maxLines = 1,
            singleLine = true,

            trailingIcon = {
                Icon(
                    imageVector = iconVisibility1,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable { visibilityOnOrOff = !visibilityOnOrOff }

                )
            },

            visualTransformation = if (visibilityOnOrOff) {
                PasswordVisualTransformation()

            } else {

                VisualTransformation.None


            },
            modifier = Modifier.constrainAs(password) {
                top.linkTo(mail.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            },


            )
        //LINIA DE LA SEGURIDAD DE LA CONTRASENYA
        LinearProgressIndicator(
            progress = when (textPassword.length) {
                in 1..3 -> 0.1f
                in 4..5 -> 0.2f
                in 6..7 -> 0.3f
                in 8..9 -> 0.4f
                in 10..12 -> 0.6f
                in 13..15 -> 0.8f
                in 16..1000 -> 1f
                else -> 0f
            },
            trackColor = when (textPassword.isEmpty()) {
                true -> Color.Transparent
                false -> Color.White

            },
            color = when (textPassword.length) {
                in 1..6 -> Color.Red
                in 7..12 -> Color.Yellow
                else -> Color.Green


            },

            modifier = Modifier.constrainAs(barSecurityIndicate) {
                start.linkTo(password.start)
                top.linkTo(password.bottom, margin = 5.dp)
                bottom.linkTo(confirmPassword.top)

            }


        )


        // CONFIRMAR CONTRASENYA
        val colorss = colorss()

        OutlinedTextField(
            value = textConfirmPassword,
            onValueChange = { textConfirmPassword = it },
            label = { Text(text = "Confirm Password") },
            isError = false,
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.constrainAs(confirmPassword) {
                top.linkTo(password.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)


            },

            colors = colorss,
            trailingIcon = {
                Icon(
                    imageVector = iconVisibility2,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable { visibilityOnOrOff1 = !visibilityOnOrOff1 }
                )
            },
            visualTransformation = if (visibilityOnOrOff1) {
                PasswordVisualTransformation()

            } else {

                VisualTransformation.None
            }

        )
        var show by remember {
            mutableStateOf(false)
        }
        AlertDialogExample(show, dismiss = {show = false}, confirm = {show = false})


        Button(
            onClick = {
                if (authent(mail = textMail , password = textPassword)) {


                }
                else {
                    show = true
                }

                


            },
            shape = CutCornerShape(3.dp),
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(confirmPassword.bottom, margin = 50.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)


            },
            colors = colorsButton(),


            enabled = emptyFieldTrueOrFalse,

            ) {
            Text(text = "Sign Up")


        }

        Text(text = "Passwords do not match", color = isErrorPasswordBecauseDontMatch, modifier = Modifier.constrainAs(matchPassword){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(confirmPassword.bottom, margin = 8.dp)
        })




    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    RegisterScreenUi(navController = rememberNavController())

}