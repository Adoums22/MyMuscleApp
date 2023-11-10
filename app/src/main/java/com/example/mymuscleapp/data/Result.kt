package com.example.mymuscleapp.data


import androidx.annotation.AnyRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("author_history")
    val authorHistory: List<String>,
    @SerialName("category")
    val category: Int,
    @SerialName("created")
    val created: String,
    @SerialName("description")
    val description: String,
    @SerialName("equipment")
    val equipment: List<Int>,
    @SerialName("exercise_base")
    val exerciseBase: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("language")
    val language: Int,
    @SerialName("license")
    val license: Int,
    @SerialName("license_author")
    val licenseAuthor: String?,
    @SerialName("muscles")
    val muscles: List<Int>,
    @SerialName("muscles_secondary")
    val musclesSecondary: List<Int>,
    @SerialName("name")
    val name: String,
    @SerialName("uuid")
    val uuid: String,
    @SerialName("variations")
    val variations: List<Int>
)