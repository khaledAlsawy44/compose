package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.Image
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.dividerColor
import com.example.androiddevchallenge.ui.theme.purpleColor
import com.example.androiddevchallenge.ui.theme.textColor

@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = dividerColor
    ) {
        Image(painterResource(id = R.drawable.ic_baseline_expand_less_24), contentDescription = null)
    }
}