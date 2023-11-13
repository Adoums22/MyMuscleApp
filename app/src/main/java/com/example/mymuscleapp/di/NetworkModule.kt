package com.example.mymuscleapp.di

import com.example.mymuscleapp.network.ApiService
import com.example.mymuscleapp.network.httpClientAndroid
import io.ktor.client.HttpClient
import org.koin.dsl.module

/**
 * Koin module for network-related dependencies.
 */
val networkModule = module {
    // Single instance of the API service
    single { provideApiService(get()) }

    // Single instance of the HTTP client
    single { provideHttpClient() }
}

/**
 * Provides an instance of the HTTP client.
 */
fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}

/**
 * Provides an instance of the API service using the provided HTTP client.
 */
fun provideApiService(httpClient: HttpClient): ApiService {
    return ApiService(httpClient)
}
