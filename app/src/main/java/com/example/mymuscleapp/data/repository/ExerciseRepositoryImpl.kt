package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.Exercise
import com.example.mymuscleapp.network.ApiService
import io.ktor.client.call.body


/**
 * Implementation of [ExerciseRepository] that interacts with the [ApiService] to fetch exercises.
 *
 * @param apiService The service responsible for API calls.
 */
class ExerciseRepositoryImpl(
    private val apiService: ApiService
) : ExerciseRepository {

    /**
     * Fetches a list of exercises using the [ApiService].
     *
     * @return Result object containing either a list of exercises on success or an exception on failure.
     */
    override suspend fun getExercises(): Result<Exercise> {
        return try {
            Result.success(apiService.getExercises().body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}




