package com.example.androiddevchallenge.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun FloatingActionButtonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        MySootheTheme.DarkColorPalette.copy(
            secondary = MaterialTheme.colors.primary
        )
    } else {
        MySootheTheme.LightColorPalette.copy(
            secondary = MaterialTheme.colors.primary
        )
    }

    MaterialTheme(
        colors = colors,
        typography = MySootheTheme.typography,
        shapes = MySootheTheme.shapes,
        content = content
    )

}