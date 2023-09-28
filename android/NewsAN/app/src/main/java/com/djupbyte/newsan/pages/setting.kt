package com.example.anNews.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Setting(onHome: () -> Unit, name: String, modifier: Modifier = Modifier){
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
    horizontalAlignment= Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Search"
        )
        Button(onClick = onHome) {
            Text("Go to Settings")
        }
    }
}