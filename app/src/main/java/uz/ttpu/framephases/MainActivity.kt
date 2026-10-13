package uz.ttpu.framephases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import uz.ttpu.framephases.ui.theme.FramePhasesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FramePhasesTheme {
                MaterialTheme {
                    StackBelow(Modifier.fillMaxWidth(), spacing = 8.dp) {
                        Box(Modifier.fillMaxWidth().height(120.dp).background(Color(0xFF6650A4)))
                        Text("I'm below the image")
                    }
                }
            }
        }
    }
}