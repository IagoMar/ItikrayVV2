package tikray.iago.tikray2v.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AlertDialogExample(show:Boolean, dismiss: () -> Unit, confirm: () -> Unit, textTitle:String, textBody:String) {

    if (show) {
        AlertDialog(

            title = { Text(text = textTitle) },
            text = { Text(text = textBody) },
            onDismissRequest =   { dismiss() },
            confirmButton = {
                TextButton(onClick = { confirm()  }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { dismiss() }) {
                    Text("Cerrar")
                }

            }
        )

    }

}

