package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    @SerialName("full_name")
    val fullName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("short_name")
    val shortName: String,
    @SerialName("url")
    val url: String
)