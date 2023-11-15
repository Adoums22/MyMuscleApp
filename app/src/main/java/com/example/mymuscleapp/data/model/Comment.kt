package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    @SerialName("comment")
    val comment: String? = null,
    @SerialName("exercise")
    val exercise: Int? = null,
    @SerialName("id")
    val id: Int? = null
)