package com.example.androiddevchallenge.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun MySootheTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textStyle: TextStyle = LocalTextStyle.current,
    isError: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    MySootheTextFieldTheme() {
        TextField(
            modifier = modifier.height(56.dp),
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            singleLine = true,
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            isError = isError,
            leadingIcon=leadingIcon,
            visualTransformation = visualTransformation
        )
    }

}

@Composable
fun MySootheTextFieldTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    val colors = if (darkTheme) {
        MySootheTheme.DarkColorPalette.copy(
            primary = MySootheTheme.LightColorPalette.onPrimary

        )
    } else {
        MySootheTheme.LightColorPalette.copy(
            primary = MySootheTheme.DarkColorPalette.onPrimary
        )
    }

    MaterialTheme(
        colors = colors,
        typography = com.example.androiddevchallenge.ui.theme.MySootheTheme.typography,
        shapes = com.example.androiddevchallenge.ui.theme.MySootheTheme.shapes,
        content = content
    )

}