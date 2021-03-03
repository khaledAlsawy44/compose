package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.textColor
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun HomeHeader() {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val (menuIcon, locationTitle, locationText, dropDownIcon, profileImage) = createRefs()
        Image(
            modifier = Modifier.constrainAs(menuIcon) {
                top.linkTo(parent.top, margin = 16.dp)
            },
            painter = painterResource(R.drawable.ic_menu),
            contentDescription = null,
        )

        Text(
            text = "Location",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor,
            modifier = Modifier.constrainAs(locationTitle) {
                top.linkTo(parent.top, margin = 4.dp)
                start.linkTo(menuIcon.end, margin = 16.dp)
            }
        )

        Text(
            text = "Louran, Alexandira",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.body2,
            color = textColor,
            modifier = Modifier.constrainAs(locationText) {
                top.linkTo(locationTitle.bottom)
                start.linkTo(locationTitle.start)
            }
        )
        Image(
            painter = painterResource(R.drawable.ic_baseline_expand_more_24),
            contentDescription = null,
            modifier = Modifier.constrainAs(dropDownIcon) {
                top.linkTo(locationText.top)
                bottom.linkTo(locationText.bottom)
                start.linkTo(locationText.end, margin = 8.dp)
            }
        )

        Surface(
            modifier = Modifier
                .size(45.dp)
                .constrainAs(profileImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            CoilImage(
                data = "https://images.unsplash.com/photo-1534318400171-5d69d3e4c394?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
@Preview
fun HomePreview() {
    MyTheme {
        HomeHeader()
    }
}