package com.example.androiddevchallenge.screen.bottomNav

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.*

@Composable
fun MySootheBottomNavTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        MySootheTheme.DarkColorPalette.copy(
            primary = Color.Gray900,
            onPrimary = Color.Taupe100
        )
    } else {
        MySootheTheme.LightColorPalette.copy(
            primary = Color.Taupe100,
            onPrimary = Color.Taupe800
        )
    }

    MaterialTheme(
        colors = colors,
        typography = MySootheTheme.typography,
        shapes = MySootheTheme.shapes,
        content = content
    )

}