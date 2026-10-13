package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScrollToTop() {
    val listState = rememberLazyListState()
    val compositions = remember { intArrayOf(0) }

    // FIX: Move scope creation here
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }

    SideEffect { Log.d("Derived", "composition #${++compositions[0]}") }

    Box(Modifier.fillMaxSize()) {
        LazyColumn(state = listState) {
            items(200) { index ->
                Text("Item $index", Modifier.fillMaxWidth().padding(16.dp))
            }
        }
        if (showButton) {
            Button(
                onClick = {
                    // Use the pre-created scope
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
            ) {
                Text("Top")
            }
        }
    }
}