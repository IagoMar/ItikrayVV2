package tikray.iago.tikray2v.firebase.auth

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Abc
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth



@Preview
@Composable
fun Preview () {
    AlertDialogExample(
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { /*TODO*/ },
        dialogTitle = "HOLA",
        dialogText = "Adios",
        icon = Icons.Rounded.Error,
    )

}
@Composable

fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
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

fun authent(mail: String, password: String) {
    FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {


            } else {
            }

        }

}

