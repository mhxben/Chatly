package com.example.chatly.View.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryText(text: String , color : Color , modifier: Modifier = Modifier) {
    Text("$text" , fontSize = 22.sp , color = color, modifier = modifier)
}

@Composable
fun SecondText(text: String, color : Color , modifier: Modifier = Modifier) {
    Text("$text" , fontSize = 16.sp , color = color , modifier = modifier)
}