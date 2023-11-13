package com.example.mymuscleapp.di

import org.koin.dsl.module

/**
 * Koin module that includes submodules for ViewModel, network, and repository configurations.
 */
val appModule = module {
    // Include submodules for ViewModel, network, and repository configurations
    includes(viewModelModule, networkModule, repositoryModule)
}
