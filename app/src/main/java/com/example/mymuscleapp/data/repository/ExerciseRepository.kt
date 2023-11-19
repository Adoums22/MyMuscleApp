package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.ApiResponse
import com.example.mymuscleapp.data.model.Category
import com.example.mymuscleapp.data.model.Image

/**
 * Exercise repository interface for fetching exercises.
 */
interface ExerciseRepository {

    /**
     * Fetches a list of exercises.
     * @return Result object containing either a list of exercises on success or an exception on failure.
     */
    suspend fun getExercises(): Result<ApiResponse>
}
