package com.example.androiddevchallenge.ui.screens.puppydetails.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.cardBackGround
import com.example.androiddevchallenge.ui.theme.dividerColor
import com.example.androiddevchallenge.ui.theme.purpleColor
import com.example.androiddevchallenge.ui.theme.textColor
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
@Preview
fun Preview() {
    DetailsScreen()
}

//TODO Convert This to Separate sections
@Composable
fun DetailsScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (puppyImage, nameCard) = createRefs()
        Image(
            modifier = Modifier
                .constrainAs(puppyImage) {
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .height(400.dp),
            painter = painterResource(R.drawable.dog),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .constrainAs(nameCard) {
                    top.linkTo(puppyImage.bottom)
                    bottom.linkTo(puppyImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            backgroundColor = cardBackGround,
            shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)),
            elevation = 2.dp
        ) {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.dog_mask),
                    contentDescription = null,
                    Modifier.fillMaxWidth(),
                    alignment = Alignment.BottomEnd
                )
                Column(
                    modifier = Modifier
                        .padding(start = 18.dp, top = 24.dp, bottom = 16.dp)
                        .wrapContentHeight()
                ) {
                    Text(
                        text = "Angel",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6,
                        color = textColor
                    )
                    Row(
                        Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_pin),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Alexandria,Egypt",
                            style = MaterialTheme.typography.body1,
                            color = textColor
                        )

                    }
                }
            }
        }

        val (genderImage, genderText, genderValue, weightImage, weightText, weightValue, ageIcon, ageText, ageValue) = createRefs()

        Image(painterResource(id = R.drawable.ic_rounded_gender), contentDescription = null,
            modifier = Modifier.constrainAs(genderImage) {
                top.linkTo(nameCard.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 24.dp)
            })

        Text(
            text = "Gender",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor,
            modifier = Modifier.constrainAs(genderText) {
                top.linkTo(genderImage.top)
                start.linkTo(genderImage.end, margin = 4.dp)
            })

        Text(
            text = "Female",
            style = MaterialTheme.typography.body2,
            color = textColor,
            modifier = Modifier.constrainAs(genderValue) {
                top.linkTo(genderText.bottom)
                start.linkTo(genderImage.end, margin = 4.dp)
            })



        Image(painterResource(id = R.drawable.ic_rounded_weight), contentDescription = null,
            modifier = Modifier.constrainAs(weightImage) {
                top.linkTo(nameCard.bottom, margin = 8.dp)
                end.linkTo(weightText.start)
                start.linkTo(genderText.end, margin = 32.dp)
            })

        Text(
            text = "Weight",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor,
            modifier = Modifier.constrainAs(weightText) {
                top.linkTo(weightImage.top)
                start.linkTo(weightImage.end, margin = 4.dp)

            })

        Text(
            text = "Female",
            style = MaterialTheme.typography.body2,
            color = textColor,
            modifier = Modifier.constrainAs(weightValue) {
                top.linkTo(weightText.bottom)
                start.linkTo(weightText.start, margin = 4.dp)
            })





        Image(painterResource(id = R.drawable.ic_rounded_age), contentDescription = null,
            modifier = Modifier.constrainAs(ageIcon) {
                top.linkTo(nameCard.bottom, margin = 8.dp)
                end.linkTo(ageValue.start, margin = 4.dp)
            })

        Text(
            text = "Age",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor,
            modifier = Modifier.constrainAs(ageText) {
                top.linkTo(ageIcon.top)
                start.linkTo(ageValue.start)
            })

        Text(
            text = "2 Months",
            style = MaterialTheme.typography.body2,
            color = textColor,
            modifier = Modifier.constrainAs(ageValue) {
                top.linkTo(ageText.bottom)
                end.linkTo(parent.end, margin = 24.dp)
            })


        val (divider, ownerImage, ownerText, ownerName, description, adoptMe, phone) = createRefs()

        Divider(
            color = dividerColor, thickness = .75.dp, modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(ageIcon.bottom, margin = 24.dp)
                }
                .padding(start = 24.dp, end = 24.dp)
        )

        Surface(
            modifier = Modifier
                .size(60.dp)
                .constrainAs(ownerImage) {
                    top.linkTo(divider.bottom, margin = 24.dp)
                    start.linkTo(parent.start, 24.dp)
                },
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            CoilImage(
                data = "https://images.unsplash.com/photo-1534318400171-5d69d3e4c394?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Khaled Alsawy",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor,
            modifier = Modifier.constrainAs(ownerName) {
                top.linkTo(ownerImage.top, 8.dp)
                start.linkTo(ownerImage.end, 8.dp)
            }
        )

        Text(
            text = "Owner",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = purpleColor,
            modifier = Modifier.constrainAs(ownerText) {
                top.linkTo(ownerName.bottom)
                start.linkTo(ownerName.start)
            }
        )


        Text(
            text = "Hi! Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor  elitr, sed diam nonumy eirmod telitr, sed diam nonumy eirmod tempor empor sed diam voluptua. At vero eos et",
            style = MaterialTheme.typography.body2,
            color = textColor,
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(ownerImage.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 24.dp, end = 24.dp)
        )

        Image(Icons.Filled.Phone, contentDescription = null,
            modifier = Modifier.constrainAs(phone) {
                top.linkTo(ownerImage.top)
                bottom.linkTo(ownerImage.bottom)
                end.linkTo(parent.end, 24.dp)

            })

        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
                .constrainAs(adoptMe) {
                    top.linkTo(description.bottom, 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = "Adopt Me",
            )
        }

    }
}
