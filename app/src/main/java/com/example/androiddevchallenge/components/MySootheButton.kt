package com.example.androiddevchallenge.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.*

@Composable
fun MySootheButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {


    Button(
        onClick = onClick,
        modifier = modifier
            .height(72.dp)
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        content = content,
    )
}

@Composable
fun MySootheButtonVersion2(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {

    MySootheButtonTheme() {
        Button(
            onClick = onClick,
            modifier = modifier
                .height(72.dp)
                .fillMaxSize(),
            shape = MaterialTheme.shapes.medium,
            content = content
        )
    }

}

@Composable
fun MySootheButtonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        MySootheTheme.DarkColorPalette.copy(
            primary = Color.Rust300
        )
    } else {
        MySootheTheme.LightColorPalette.copy(
            primary = Color.Rust600
        )
    }

    MaterialTheme(
        colors = colors,
        typography = com.example.androiddevchallenge.ui.theme.MySootheTheme.typography,
        shapes = com.example.androiddevchallenge.ui.theme.MySootheTheme.shapes,
        content = content
    )

}