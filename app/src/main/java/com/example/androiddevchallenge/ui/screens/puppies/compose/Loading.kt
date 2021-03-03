package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.purpleColor
import com.example.androiddevchallenge.ui.theme.whiteIconColor

@Composable
fun Loading() {
    Box(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            CircularProgressIndicator(
                color = purpleColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
            Text(
                text = "This is the loading state, Please wait ...",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.body1,
                color = purpleColor,
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 16.dp)
            )
        }
    }
}