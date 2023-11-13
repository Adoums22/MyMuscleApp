package com.example.mymuscleapp.di

import com.example.mymuscleapp.ui.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module for ViewModel-related dependencies.
 */
val viewModelModule = module {
    // ViewModel for the main screen
    viewModel { MainViewModel(get()) }
}
