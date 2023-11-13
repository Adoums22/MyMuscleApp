package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Exercise details data class.
 * @property authorHistory List of author's historical information.
 * @property category Exercise category.
 * @property created Creation timestamp.
 * @property description Detailed exercise description.
 * @property equipment Required equipment for the exercise.
 * @property exerciseBase Base exercise identifier.
 * @property id Unique exercise identifier.
 * @property language Language code for the exercise.
 * @property license License code for the exercise.
 * @property licenseAuthor Author's information related to the license.
 * @property muscles Primary muscles targeted.
 * @property musclesSecondary Secondary muscles targeted.
 * @property name Exercise name.
 * @property uuid Universally unique identifier (UUID).
 * @property variations Exercise variations.
 */
@Serializable
data class AllExercise(
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