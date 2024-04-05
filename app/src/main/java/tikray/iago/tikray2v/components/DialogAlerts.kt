package tikray.iago.tikray2v.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AlertDialogExample(show:Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    if (show) {
        AlertDialog(

            icon = { Icon(icon, contentDescription = "Icono de ejemplo") },
            title = { Text(text = dialogTitle) },
            text = { Text(text = dialogText) },
            onDismissRequest = { onDismissRequest() },
            confirmButton = {
                TextButton(onClick = { onConfirmation() }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismissRequest() }) {
                    Text("Cerrar")
                }

            }
        )

    }

}

