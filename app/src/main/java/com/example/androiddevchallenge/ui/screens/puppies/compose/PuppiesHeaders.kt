package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.puppies.AgeType
import com.example.androiddevchallenge.ui.theme.darkIconColor
import com.example.androiddevchallenge.ui.theme.purpleColor

@Composable
fun AgeHeader(ageType: AgeType, isExpanded: Boolean) {
    val height by animateDpAsState(if (isExpanded) 80.dp else 50.dp)
    val shapeCorners by animateDpAsState(if (isExpanded) 0.dp else 8.dp)

    Surface(
        modifier = Modifier
            .padding(start = 4.dp,top = 8.dp)
            .fillMaxWidth(),
        color = purpleColor.copy(alpha = .2f),
        shape = RoundedCornerShape(topStart = 8.dp, bottomStart = shapeCorners)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.height(height)
        ) {
            val text = when (ageType) {
                AgeType.DAY -> "(-Month)"
                AgeType.MONTH -> "(-Year)"
                AgeType.YEAR -> "(+Year)"
            }

            Text(
                text = "Dogs ",
                style = MaterialTheme.typography.h6,
                color = purpleColor,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),

                )
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.h6,
                color = purpleColor,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.CenterVertically)
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
    val height by animateDpAsState(if (isExpanded) 80.dp else 50.dp)
    val shapeCorners by animateDpAsState(if (isExpanded) 0.dp else 8.dp)

    Surface(
        modifier = Modifier
            .padding(end = 4.dp,top = 8.dp)
            .fillMaxWidth(),
        color = purpleColor.copy(alpha = .2f),
        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = shapeCorners)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.height(height)
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
                    tint = darkIconColor
                )
            }
        }
    }
}


@Composable
fun ItemHeaderDivider(modifier: Modifier) {
    Divider(
        color = purpleColor.copy(alpha = .2f), thickness = 50.dp, modifier = modifier
    )
}