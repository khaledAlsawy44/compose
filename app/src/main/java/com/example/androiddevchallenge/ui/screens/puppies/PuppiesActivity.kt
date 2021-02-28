/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.puppies

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.screens.puppydetails.PuppyDetailsActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
class PuppiesActivity : AppCompatActivity() {

    private val viewModel: PuppiesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                RenderState()
            }
        }
    }

    @Composable
    private fun RenderState() {
        val state: State<PuppiesState> = viewModel.uiState.observeAsState(PuppiesState.Loading)
        when (val value = state.value) {
            is PuppiesState.Default -> {
                PuppiesList(value.puppiesData, ::onPuppyClicked, ::onExpandClicked)
            }
            PuppiesState.Loading -> {
                Loading()
            }
        }
    }


    private fun onExpandClicked(ageType: AgeType) {
        viewModel.changeAgeSectionVisibility(ageType = ageType)
    }

    private fun onPuppyClicked(puppy: Puppy) {
        startActivity(Intent(this, PuppyDetailsActivity::class.java))
    }


    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        MyTheme {
            RenderState()
        }
    }
}