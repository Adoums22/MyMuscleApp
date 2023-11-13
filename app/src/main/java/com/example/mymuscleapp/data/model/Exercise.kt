package com.example.mymuscleapp.data.model


import com.example.mymuscleapp.data.model.AllExercise
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Exercise details data class.
 * @property count Total count of exercises.
 * @property next URL for the next set of exercises.
 * @property previous URL for the previous set of exercises.
 * @property allExercises List of exercises containing detailed information.
 */
@Serializable
data class Exercise(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String?,
    @SerialName("results")
    val allExercises: List<AllExercise>
)