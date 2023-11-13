package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.Exercise

/**
 * Exercise repository interface for fetching exercises.
 */
interface ExerciseRepository {

    /**
     * Fetches a list of exercises.
     * @return Result object containing either a list of exercises on success or an exception on failure.
     */
    suspend fun getExercises(): Result<Exercise>

}
