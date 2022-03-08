package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Collection


@Composable
fun FavoriteItem(favoriteCollection: Collection) {
    Card(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp)
            .padding(end = 8.dp),
        shape = MaterialTheme.shapes.small
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = favoriteCollection.imageRes) , contentDescription = favoriteCollection.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(56.dp)
                    .fillMaxHeight()
            )

            Text(
                text = favoriteCollection.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
    }
}