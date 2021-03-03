package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.screens.puppies.AgeType
import com.example.androiddevchallenge.ui.screens.puppies.PuppiesListUiData
import com.example.androiddevchallenge.ui.screens.puppies.Puppy
import com.example.androiddevchallenge.ui.theme.textColor

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun HomeScreen(
    puppiesMap: Map<AgeType, PuppiesListUiData>,
    onPuppyClicked: (puppy: Puppy) -> Unit,
    onExpandClicked: (ageType: AgeType) -> Unit
) {
    Column {
        HomeHeader()
        Text(
            text = "Choose Your \nLovely Pet",
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.h5,
            color = textColor,
            modifier = Modifier.padding(start = 16.dp),
        )

        Spacer(modifier = Modifier.height(32.dp))
        PetsList()

        Spacer(modifier = Modifier.height(24.dp))

        // Grid List
        PuppiesAsGrid(
            puppiesMap = puppiesMap,
            onPuppyClicked = onPuppyClicked,
            onExpandClicked = onExpandClicked
        )

        // Nested Lists ( horizontal lists inside a vertical list )
//        PuppiesAsNestedLists(
//            puppiesMap = puppiesMap,
//            onPuppyClicked = onPuppyClicked
//        )
    }
}