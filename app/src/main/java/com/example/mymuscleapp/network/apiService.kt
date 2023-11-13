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
        private const val BASE_URL = "https://wger.de/api/v2"
        private const val LANGUAGE_PARAM = "language=2"
        private const val EXERCISES_ENDPOINT = "exercise"
    }

    /**
     * Function to get a list of exercises from the API.
     *
     * @return A response from the API containing exercises.
     */
    suspend fun getExercises() = client.get("$BASE_URL$EXERCISES_ENDPOINT/?$LANGUAGE_PARAM")
}
