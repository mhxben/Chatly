package com.example.chatly
import android.graphics.BitmapFactory
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.example.chatly.component.AppImage
import kotlinx.coroutines.delay

@Composable
fun LandingPage(onNavigateToLogin: () -> Unit) {
    val context = LocalContext.current


    val backgroundBitmap = remember {
        val options = BitmapFactory.Options().apply {
            inSampleSize = 2
        }
        BitmapFactory.decodeResource(context.resources, R.drawable.background, options)
    }

    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2000)
        )
        delay(1000)
        onNavigateToLogin()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            bitmap = backgroundBitmap.asImageBitmap(),
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
