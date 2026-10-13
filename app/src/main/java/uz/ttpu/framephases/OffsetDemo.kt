package uz.ttpu.framephases

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.roundToInt

@Composable
fun OffsetDemo() {
    var offsetX by remember { mutableStateOf(0.dp) }
    SideEffect { Log.d("Phases", "OffsetDemo: composition") }

    Column {
        Button(onClick = { offsetX = if (offsetX == 0.dp) 80.dp else 0.dp }) {
            Text("Move")
        }
        // new line, above the Text:
        val offsetPx = with(LocalDensity.current) { offsetX.roundToPx() }

        Text(
            text = "Offset demo",
            modifier = Modifier
                .offset { IntOffset(offsetPx, 0) }
                .logPhases("offset demo"),
        )
        Text(
            text = "Offset demo",
            modifier = Modifier
                .offset { IntOffset(offsetX.value.roundToInt(), 0) }
                .logPhases("offset demo"),
        )
    }
}