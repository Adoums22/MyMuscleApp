package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)