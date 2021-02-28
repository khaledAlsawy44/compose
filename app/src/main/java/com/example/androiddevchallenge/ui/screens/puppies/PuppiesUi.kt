package com.example.androiddevchallenge.ui.screens.puppies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.*
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun PuppiesList(
    puppiesMap: Map<AgeType, PuppiesListUiData>,
    onPuppyClicked: (puppy: Puppy) -> Unit,
    onExpandClicked: (ageType: AgeType) -> Unit
) {
    Box {
        val scrollState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            state = scrollState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 64.dp, start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            puppiesMap.forEach { (ageType, puppiesData) ->
                item {
                    PuppyAgeHeader(
                        ageType = ageType
                    )
                }

                item {
                    PuppyAgeHeaderExpandItem(
                        ageType,
                        puppiesData.isExpanded,
                        onExpandClicked
                    )
                }
                if (puppiesData.isExpanded) {
                    items(puppiesData.puppiesList) { puppy ->
                        PuppyItem(puppy, onPuppyClicked)
                    }
                    if (puppiesData.puppiesList.size % 2 != 0) {
                        item { }
                    }
                }
            }

        }
        val showButton = scrollState.firstVisibleItemIndex > 0
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            ScrollToTopButton(onClick = {
                scope.launch {
                    scrollState.animateScrollToItem(0)
                }
            })
        }
    }
}

@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = Color.Gray
    ) {
        Image(Icons.Filled.ArrowDropUp, contentDescription = null)
    }
}

@Composable
fun PuppyAgeHeader(ageType: AgeType) {
    Surface(
        color = purpleColor.copy(alpha = .2f),
        shape = RoundedCornerShape(topStart = 16.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .height(70.dp)
        ) {
            Text(
                text = when (ageType) {
                    AgeType.DAY -> "Under Month"
                    AgeType.MONTH -> "Under Year"
                    AgeType.YEAR -> "Above a Year"
                },
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.body1,
                color = purpleColor,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun PuppyAgeHeaderExpandItem(
    ageType: AgeType,
    isExpanded: Boolean,
    onExpandClicked: (ageType: AgeType) -> Unit
) {
    Surface(
        color = purpleColor.copy(alpha = .2f),
        shape = RoundedCornerShape(topEnd = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .height(70.dp)
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                onClick = { onExpandClicked(ageType) }
            ) {
                Icon(
                    painterResource(
                        if (isExpanded) R.drawable.ic_baseline_expand_less_24
                        else R.drawable.ic_baseline_expand_more_24
                    ),
                    contentDescription = null,
                    tint = darkIconColor,

                    )
            }
        }
    }
}


@Composable
fun PuppyItem(puppy: Puppy, onClick: (puppy: Puppy) -> Unit) {
    Box(
    ) {
        Divider(color =purpleColor.copy(alpha = .2f), thickness = 50.dp)
        Box(
            modifier = Modifier
                .padding(4.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topEnd = CornerSize(18.dp),
                        topStart = CornerSize(18.dp),
                        bottomStart = CornerSize(12.dp),
                        bottomEnd = CornerSize(12.dp)
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight()
                .background(cardBackGround)
        ) {
            PuppyPicture(picture = puppy.puppyPicture)
            Card(
                backgroundColor = cardBackGround,
                shape = CircleShape.copy(
                    bottomEnd = CornerSize(12.dp),
                    bottomStart = CornerSize(12.dp),
                    topStart = CornerSize(12.dp),
                    topEnd = CornerSize(12.dp)
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight()
                    .padding(bottom = 16.dp),
                elevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = puppy.puppyName.name,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                        color = textColor
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Image(
                            painterResource(R.drawable.ic_time),
                            contentDescription = null,
                            modifier = Modifier.align(
                                Alignment.CenterVertically
                            )
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "${puppy.puppyAge.age} ${puppy.puppyAge.ageType.shortCut}",
                            style = MaterialTheme.typography.body2,
                            color = textColor,
                            modifier = Modifier.weight(.2f),
                        )


                        Image(
                            painterResource(R.drawable.ic_sex),
                            contentDescription = null,
                            modifier = Modifier.align(
                                Alignment.CenterVertically
                            )
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = puppy.puppyGender.gender,
                            style = MaterialTheme.typography.body2,
                            color = textColor,
                            modifier = Modifier.weight(.2f)
                        )
                    }
                }
            }
        }
    }
}

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
                color = whiteIconColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
            Text(
                text = "Loading The Puppies, Please wait ...",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.body1,
                color = whiteIconColor,
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 16.dp)
            )
        }
    }
}
