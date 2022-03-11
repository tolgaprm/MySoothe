package com.example.androiddevchallenge.components

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TitleText(modifier: Modifier = Modifier, @StringRes titleResourceId: Int) {
    Text(
        text = stringResource(titleResourceId).uppercase(),
        style = MaterialTheme.typography.h2,
        modifier = modifier
    )
}