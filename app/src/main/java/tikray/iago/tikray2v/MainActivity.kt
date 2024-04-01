package tikray.iago.tikray2v

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import tikray.iago.tikray2v.ui.theme.Tikray2VTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tikray2VTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(19, 18, 69)
                ) {

                }
            }
        }
    }
}


@Composable
fun ScreenRegister(modifier: Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        

    }



}






@Preview(showSystemUi = true)
@Composable
fun Preview() {
    ScreenRegister(Modifier.background(Color(19, 18, 69)))


}