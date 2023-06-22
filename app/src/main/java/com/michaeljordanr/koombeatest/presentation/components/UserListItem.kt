package com.michaeljordanr.koombeatest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.michaeljordanr.koombeatest.domain.model.User

@Composable
fun UserListItem(user: User) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        ImageItem(imageUrl = user.pictureURL)
        Text(
            text = "${user.firstName} ${user.lastName}",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ImageItem(imageUrl: String) {
    Surface(shape = MaterialTheme.shapes.medium) {
        Image(
            painter = rememberAsyncImagePainter(
                imageUrl
            ),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )
    }
}