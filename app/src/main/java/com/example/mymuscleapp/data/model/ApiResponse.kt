package com.example.mymuscleapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("results")
    val results: List<Result>?
)
