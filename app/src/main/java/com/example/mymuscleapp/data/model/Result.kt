package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("aliases")
    val aliases: List<String?>,
    @SerialName("author_history")
    val authorHistory: List<String?>? = null,
    @SerialName("category")
    val category: Category,
    @SerialName("comments")
    val comments: List<Comment>,
    @SerialName("created")
    val created: String,
    @SerialName("description")
    val description: String,
    @SerialName("equipment")
    val equipment: List<Equipment>,
    @SerialName("exercise_base_id")
    val exerciseBaseId: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<Image>? =null,
    @SerialName("language")
    val language: Language,
    @SerialName("license")
    val license: License,
    @SerialName("license_author")
    val licenseAuthor: String? = null,
    @SerialName("muscles")
    val muscles: List<Muscle>,
    @SerialName("muscles_secondary")
    val musclesSecondary: List<MusclesSecondary>,
    @SerialName("name")
    val name: String,
    @SerialName("uuid")
    val uuid: String,
    @SerialName("variations")
    val variations: List<Int>,
    @SerialName("videos")
    val videos: List<Video>? = null
)