package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.ApiResponse
import com.example.mymuscleapp.data.model.Category
import com.example.mymuscleapp.data.model.Image
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
    override suspend fun getExercises(): Result<ApiResponse> {
        return try {
            Result.success(apiService.getExercises().body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}




