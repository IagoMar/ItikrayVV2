package tikray.iago.tikray2v.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import tikray.iago.tikray2v.R
import tikray.iago.tikray2v.screens.prefabricados.colorsButton
import tikray.iago.tikray2v.screens.prefabricados.colorss
import tikray.iago.tikray2v.screens.ui.theme.Tikray2VTheme

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreenUI(navController = rememberNavController())

                }
            }
        }
    }
}


@Composable
fun LoginScreenUI(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.tikrayColor1))
    ) {


        //definicion de variables para la colocación de los elementos
        val (title, logo, mailField, passwdField, forgetPassword, button1) = createRefs()

        // variables para los estados
        var textMail by remember { mutableStateOf(" ") }
        var textPasswd by remember { mutableStateOf("") }
        var visibilityOnOrOff by remember { mutableStateOf(true) }
        val topMargin = createGuidelineFromTop(0.08f)


        val iconVisibility1 = if (visibilityOnOrOff) {
            Icons.Filled.VisibilityOff
        } else {
            Icons.Filled.Visibility
        }


        Image(
            painter = painterResource(id = R.drawable.logo_empresa),
            contentDescription = "logo company",
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(topMargin)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )

        Text(
            text = "LOGIN",
            style = TextStyle(fontSize = 45.sp, color = Color.White),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(logo.bottom, margin = 25.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })

        OutlinedTextField(
            value = textMail, onValueChange = { textMail = it },
            label = { Text(text = "Mail") },
            isError = false,
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.constrainAs(mailField) {
                top.linkTo(title.bottom, margin = 100.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            },
            colors = colorss()
        )


        OutlinedTextField(
            value = textPasswd,
            onValueChange = { textPasswd = it },
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
            modifier = Modifier.constrainAs(passwdField) {
                top.linkTo(mailField.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)


            })
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .width(120.dp)
                .constrainAs(button1) {
                    top.linkTo(passwdField.bottom, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)


                },
            enabled = if (textMail.isEmpty() || textPasswd.isEmpty() || textPasswd.length <= 7) false else true,
            colors = colorsButton(),
            shape = CutCornerShape(3.dp)
        ) {
            Text(text = "LOGIN")


        }

    }


}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    LoginScreenUI(navController = rememberNavController())

}