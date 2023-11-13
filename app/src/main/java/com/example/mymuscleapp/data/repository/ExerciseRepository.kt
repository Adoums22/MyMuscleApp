package com.example.mymuscleapp.data.repository

import com.example.mymuscleapp.data.model.Exercise

interface ExerciseRepository {
    suspend fun getExercises(): Result<Exercise>

}