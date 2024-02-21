package com.example.composepaging3caching.di

import com.example.composepaging3caching.presentation.BeerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { BeerViewModel(get()) }
}