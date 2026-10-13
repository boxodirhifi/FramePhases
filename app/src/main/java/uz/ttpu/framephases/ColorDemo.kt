package uz.ttpu.framephases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import android.util.Log

@Composable
fun ColorDemo() {
    var color by remember { mutableStateOf(Color.Red) }
    SideEffect { Log.d("Phases", "ColorDemo: composition") }

    Column(modifier = Modifier.padding(top = 48.dp)) {
        Button(onClick = { color = if (color == Color.Red) Color.Blue else Color.Red }) {
            Text("Change color")
        }
        // EXPERIMENT: Box instead of Canvas
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color) // Read happens HERE, during composition/modifier building
                .logPhases("box demo")
        )
    }
}