package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Collection


@Composable
fun FavoriteItem(favoriteCollection: Collection) {
    Card(
        modifier = Modifier
            .size(width = 192.dp, height = 56.dp),
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(id = favoriteCollection.imageRes),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop,
            )

            Text(
                favoriteCollection.name,
                modifier = Modifier.weight(1F),
                style = MaterialTheme.typography.h3,
            )
        }
    }


}