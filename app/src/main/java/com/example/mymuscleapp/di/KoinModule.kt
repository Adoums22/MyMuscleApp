package com.example.mymuscleapp.di

import com.example.mymuscleapp.data.repository.ExerciseRepository
import com.example.mymuscleapp.data.repository.ExerciseRepositoryImpl
import com.example.mymuscleapp.network.httpClientAndroid
import com.example.mymuscleapp.ui.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Déclaration du ExerciseRepository avec Koin
    single<ExerciseRepository> { ExerciseRepositoryImpl(get()) }

    single { httpClientAndroid }

    viewModel { MainViewModel(get()) }

}