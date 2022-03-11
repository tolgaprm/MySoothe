package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Collection

@Composable
fun AlignYourRowItem(collection: Collection) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = collection.imageRes),
            contentDescription = collection.name,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = collection.name, modifier = Modifier.paddingFromBaseline(24.dp),
            style = MaterialTheme.typography.h3
        )


    }
}

