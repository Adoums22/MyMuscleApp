package com.example.mymuscleapp.di


import com.example.mymuscleapp.data.repository.ExerciseRepositoryImpl
import com.example.mymuscleapp.network.ApiService
import org.koin.dsl.module

/**
 * Koin module for repository-related dependencies.
 */
val repositoryModule = module {
    // Single instance of the remote repository
    single { provideRemoteRepository(get()) }
}

/**
 * Provides an instance of the remote repository using the provided API service.
 */
fun provideRemoteRepository(apiService: ApiService): ExerciseRepositoryImpl {
    return ExerciseRepositoryImpl(apiService)
}
