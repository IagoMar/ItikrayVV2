
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import tikray.iago.tikray2v.components.AlertDialogExample



fun authent( mail: String, password: String):Boolean {


    var show:Boolean = false


    FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                show = false




            } else {
                show = true






            }


        }
    return show


}


