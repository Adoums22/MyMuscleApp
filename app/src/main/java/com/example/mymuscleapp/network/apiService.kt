package com.example.mymuscleapp.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

/**
 * Service class for making API requests related to exercises.
 *
 * @param client The HttpClient used for making HTTP requests.
 */
class ApiService(private val client: HttpClient) {

    // Companion object to hold constant values
    companion object {
        private const val BASE_URL = "https://wger.de/api/v2/"
        private const val LANGUAGE_PARAM = "language=2"
        private const val EXERCISES_ENDPOINT = "exerciseinfo"
        private const val CATEGORIES_ENDPOINT = "exercisecategory"
        private const val IMAGES_ENDPOINT = "exerciseimage"
    }

    /**
     * Function to get a list of exercises from the API.
     *
     * @return A response from the API containing exercises.
     */
    suspend fun getExercises() = client.get("$BASE_URL$EXERCISES_ENDPOINT/?$LANGUAGE_PARAM")

    suspend fun getCategory() = client.get("$BASE_URL$CATEGORIES_ENDPOINT/?$LANGUAGE_PARAM")

    suspend fun getImage() = client.get("$BASE_URL$IMAGES_ENDPOINT/?$LANGUAGE_PARAM")
}