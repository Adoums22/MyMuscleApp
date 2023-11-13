package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.AllExercise
import com.example.mymuscleapp.data.model.Exercise
import com.example.mymuscleapp.network.ApiService
import io.ktor.client.call.body


class ExerciseRepositoryImpl(
    private val apiService: ApiService
) : ExerciseRepository {
    override suspend fun getExercises(): Result<Exercise> {
        return try {
            Result.success(apiService.getExercises().body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}



