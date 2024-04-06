package tikray.iago.tikray2v.screens.prefabricados

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import tikray.iago.tikray2v.R


@Composable
fun colorss():TextFieldColors{
    val colors = colors(
        unfocusedBorderColor = Color.White,
        focusedBorderColor = Color.Gray,
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        cursorColor = Color.Transparent,

        )
return colors}


@Composable
fun colorsButton(): ButtonColors {
    val colors = ButtonDefaults.buttonColors(
        contentColor = colorResource(id = R.color.tikrayColor1),
        containerColor = Color.White,
        disabledContainerColor = Color.Gray
    )
    return colors




}


