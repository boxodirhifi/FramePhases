package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun StackBelow(
    modifier: Modifier = Modifier,
    spacing: Dp = 8.dp,
    content: @Composable () -> Unit,
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val loose = constraints.copy(minWidth = 0, minHeight = 0)

        // TODO 1: Measure children
        val placeables = measurables.map { measurable ->
            Log.d("StackBelow", "measure child")
            measurable.measure(loose)
        }

        // TODO 2: Decide own size
        val spacingPx = spacing.roundToPx()
        val width = placeables.maxOfOrNull { it.width } ?: 0
        val height = placeables.sumOf { it.height } + (placeables.size - 1) * spacingPx

        layout(constraints.constrainWidth(width), constraints.constrainHeight(height)) {
            // TODO 3: Place children
            Log.d("StackBelow", "place children")
            var yPosition = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height + spacingPx
            }
        }
    }
}