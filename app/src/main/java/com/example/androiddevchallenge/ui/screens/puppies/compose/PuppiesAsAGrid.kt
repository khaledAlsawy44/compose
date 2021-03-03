package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.screens.puppies.AgeType
import com.example.androiddevchallenge.ui.screens.puppies.PuppiesListUiData
import com.example.androiddevchallenge.ui.screens.puppies.Puppy
import kotlinx.coroutines.launch

enum class ItemPosition(val index: Int) {
    LEFT(0), RIGHT(1), OTHER(-1)
}


@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun PuppiesAsGrid(
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
                    AgeHeader(
                        ageType = ageType,
                        puppiesData.isExpanded
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
                    itemsIndexed(puppiesData.puppiesList) { index, puppy ->
                        PuppyGridItem(
                            puppy,
                            onPuppyClicked,
                            when (index) {
                                ItemPosition.LEFT.index -> ItemPosition.LEFT
                                ItemPosition.RIGHT.index -> ItemPosition.RIGHT
                                else -> ItemPosition.OTHER
                            }
                        )
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
