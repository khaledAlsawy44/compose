package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.puppies.Puppy
import com.example.androiddevchallenge.ui.theme.cardBackGround
import com.example.androiddevchallenge.ui.theme.textColor


@Composable
fun PuppyGridItem(puppy: Puppy, onClick: (puppy: Puppy) -> Unit, position: ItemPosition) {
    Box {
        when (position) {
            ItemPosition.LEFT -> ItemHeaderDivider(Modifier.padding(start = 4.dp))
            ItemPosition.RIGHT -> ItemHeaderDivider(Modifier.padding(end = 4.dp))
            ItemPosition.OTHER -> {
            }
        }
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
                .clickable { onClick(puppy) }
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
                    .padding(bottom = 4.dp),
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

