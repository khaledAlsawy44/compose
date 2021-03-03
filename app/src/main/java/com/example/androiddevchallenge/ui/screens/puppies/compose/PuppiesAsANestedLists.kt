package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.puppies.AgeType
import com.example.androiddevchallenge.ui.screens.puppies.PuppiesListUiData
import com.example.androiddevchallenge.ui.screens.puppies.Puppy
import com.example.androiddevchallenge.ui.screens.puppies.PuppyPicture
import com.example.androiddevchallenge.ui.theme.cardBackGround
import com.example.androiddevchallenge.ui.theme.purpleColor
import com.example.androiddevchallenge.ui.theme.textColor
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun PuppiesAsNestedLists(
    puppiesMap: Map<AgeType, PuppiesListUiData>,
    onPuppyClicked: (puppy: Puppy) -> Unit
) {
    LazyColumn {
        puppiesMap.forEach { (ageType, puppiesData) ->
            item {
                PuppyAgeSectionItem(ageType, puppiesData, onPuppyClicked)
            }
        }
    }
}


@Composable
fun PuppyAgeSectionItem(
    ageType: AgeType,
    data: PuppiesListUiData,
    onPuppyClicked: (puppy: Puppy) -> Unit
) {
    Column {
        val text = when (ageType) {
            AgeType.DAY -> "(-Month)"
            AgeType.MONTH -> "(-Year)"
            AgeType.YEAR -> "(+Year)"
        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = "Dogs ",
                style = MaterialTheme.typography.h6,
                color = purpleColor,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            )
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.h6,
                color = purpleColor,
                modifier = Modifier
                    .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
            )
        }

        LazyRow {
            items(data.puppiesList) {
                PuppyItem(it, onPuppyClicked)
            }
        }
    }
}


@Composable
fun PuppyItem(
    puppy: Puppy, onPuppyClicked: (puppy: Puppy) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 8.dp)
            .clickable {
                onPuppyClicked(puppy)
            },
        backgroundColor = cardBackGround,
        elevation = 1.dp,
        shape = CircleShape.copy(CornerSize(20.dp)),
    ) {
        Column(Modifier.fillMaxWidth()) {
            PuppyPictureHorizontal(picture = puppy.puppyPicture)

            ConstraintLayout(
                modifier = Modifier
                    .width(200.dp)
                    .padding(16.dp)
            ) {
                val (nameText, ageIcon, ageText, sexIcon, sexText) = createRefs()
                Text(
                    text = puppy.puppyName.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    color = textColor,
                    modifier = Modifier
                        .constrainAs(nameText) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                )

                Image(
                    painterResource(R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(ageIcon) {
                            top.linkTo(nameText.bottom, margin = 8.dp)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                        .size(16.dp)
                )
                Text(
                    text = "${puppy.puppyAge.age} ${puppy.puppyAge.ageType.shortCut}",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    modifier = Modifier.constrainAs(ageText) {
                        top.linkTo(ageIcon.top)
                        bottom.linkTo(ageIcon.bottom)
                        start.linkTo(ageIcon.end, margin = 8.dp)
                    }
                )
                Text(
                    text = puppy.puppyGender.gender,
                    style = MaterialTheme.typography.body2,
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(sexText) {
                        top.linkTo(ageIcon.top)
                        bottom.linkTo(ageIcon.bottom)
                        end.linkTo(parent.end)
                    }
                )

                Image(
                    painterResource(R.drawable.ic_sex),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(sexIcon) {
                            top.linkTo(ageIcon.top)
                            bottom.linkTo(ageIcon.bottom)
                            end.linkTo(sexText.start, margin = 8.dp)
                        }
                        .size(16.dp)
                )

            }
        }
    }
}


@Composable
fun PuppyPictureHorizontal(picture: PuppyPicture) {
    CoilImage(
        data = picture.url,
        contentDescription = "My content description",
        fadeIn = true,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(220.dp, 150.dp)
    )
}



