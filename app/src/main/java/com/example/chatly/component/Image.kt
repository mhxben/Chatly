package com.example.chatly.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AppImage (
    imageRes: Int,
    contentDescription: String,
    size: Int = 100
){
    Image(
        painter = painterResource(id = imageRes),
        contentDescription =  contentDescription,
        modifier = Modifier.size(size.dp)
    )
}