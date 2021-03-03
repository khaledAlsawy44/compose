package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.screens.puppies.PuppyPicture
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun PuppyPicture(picture: PuppyPicture) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(bottom = 32.dp)
            .clip(RoundedCornerShape(12.dp)),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
    ) {
        CoilImage(
            data = picture.url,
            contentDescription = "My content description",
            fadeIn = true,
            contentScale = ContentScale.Crop
        )
    }
}
