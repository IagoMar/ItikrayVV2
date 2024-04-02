package tikray.iago.tikray2v.screens.prefabricados

import androidx.compose.runtime.Composable

@Composable
fun viewPassword(passwordLength: Int): String {
    val astherisc = "*"
    return astherisc.repeat(passwordLength)


}

fun fieldsNotEmpty(a: String, b:String, c:String, d: String):Int{
    var fieldEmptyNumber = 0
    if (a.isEmpty())  fieldEmptyNumber = 1
    if (b.isEmpty())  fieldEmptyNumber = 2
    if (c.isEmpty())  fieldEmptyNumber = 3
    if (d.isEmpty())  fieldEmptyNumber = 4
    return fieldEmptyNumber
}









fun buttonEnabledOrDisabled() {

}


