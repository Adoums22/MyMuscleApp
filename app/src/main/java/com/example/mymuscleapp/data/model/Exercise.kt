package com.example.mymuscleapp.data.model


import com.example.mymuscleapp.data.model.AllExercise
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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