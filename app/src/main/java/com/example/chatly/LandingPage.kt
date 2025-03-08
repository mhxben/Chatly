package com.example.chatly.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatly.R
import com.example.chatly.component.AppImage
import kotlinx.coroutines.delay

@Composable
fun LandingPage(onNavigateToLogin: () -> Unit) {

    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
        )
        delay(1000)
        onNavigateToLogin()
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alphaAnim.value),
            contentAlignment = Alignment.Center
        ) {
            AppImage(R.drawable.logo2, "App Logo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LandingPage(onNavigateToLogin = {})
}
