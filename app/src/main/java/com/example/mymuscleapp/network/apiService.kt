package com.example.mymuscleapp.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT = "https://wger.de/api/v2/"
        private const val EXERCISES = "exercise"
    }

    suspend fun getExercises() = client.get("$END_POINT$EXERCISES")
}