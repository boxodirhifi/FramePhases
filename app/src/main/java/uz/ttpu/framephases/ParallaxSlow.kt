package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ParallaxSlow() {
    val listState = rememberLazyListState()
    val compositions = remember { intArrayOf(0) }

    // Log composition count
    SideEffect {
        Log.d("Parallax", "slow: composition #${++compositions[0]}")
    }

    Box {
        // The parallax header
        Box(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFF6650A4))
                .offset(
                    y = with(LocalDensity.current) {
                        (listState.firstVisibleItemScrollOffset / 2).toDp()
                    }
                )
        )

        // The scrolling list
        LazyColumn(state = listState) {
            items(100) { index ->
                Text("Item $index", Modifier.fillMaxWidth().padding(16.dp))
            }
        }
    }
}