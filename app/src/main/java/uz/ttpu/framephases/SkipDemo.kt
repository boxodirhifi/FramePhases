package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun SkipDemo() {
    var count by remember { mutableIntStateOf(0) }

    ParentLambda(count = { count }, onIncrement = { count++ })
}

@Composable
fun ParentLambda(count: () -> Int, onIncrement: () -> Unit) {
    SideEffect { Log.d("Skip", "ParentLambda: composition") }
    Column {
        Button(onClick = onIncrement) { Text("Add") }
        ChildLambda(count)
        Sibling()
    }
}

@Composable
fun ChildLambda(count: () -> Int) {
    SideEffect { Log.d("Skip", "ChildLambda: composition") }
    Text("Count: ${count()}")
}

@Composable
fun Sibling() {
    SideEffect { Log.d("Skip", "Sibling: composition") }
    Text("I never change")
}