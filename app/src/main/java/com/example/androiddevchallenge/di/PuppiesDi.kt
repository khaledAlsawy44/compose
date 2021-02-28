package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.ui.screens.puppies.PuppiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val puppiesModule = module {
    viewModel { PuppiesViewModel() }
}

