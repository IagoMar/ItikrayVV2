package tikray.iago.tikray2v.screens.prefabricados

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


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



