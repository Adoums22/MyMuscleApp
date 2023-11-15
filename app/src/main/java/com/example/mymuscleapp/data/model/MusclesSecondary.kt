package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MusclesSecondary(
    @SerialName("id")
    val id: Int,
    @SerialName("image_url_main")
    val imageUrlMain: String,
    @SerialName("image_url_secondary")
    val imageUrlSecondary: String,
    @SerialName("is_front")
    val isFront: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("name_en")
    val nameEn: String
)