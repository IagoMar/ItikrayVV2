package tikray.iago.tikray2v.screens.prefabricados

import androidx.compose.runtime.Composable

@Composable
fun viewPassword(passwordLength: Int): String {
    val astherisc = "*"
    return astherisc.repeat(passwordLength)


}


