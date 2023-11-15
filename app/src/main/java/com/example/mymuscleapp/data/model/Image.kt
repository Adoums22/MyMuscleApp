package com.example.mymuscleapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("author_history")
    val authorHistory: List<String>? = null,
    @SerialName("exercise_base")
    val exerciseBase: Int? = null,
    @SerialName("exercise_base_uuid")
    val exerciseBaseUuid: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("is_main")
    val isMain: Boolean? = null,
    @SerialName("license")
    val license: Int? = null,
    @SerialName("license_author")
    val licenseAuthor: String? = null,
    @SerialName("license_author_url")
    val licenseAuthorUrl:  String? = null,
    @SerialName("license_derivative_source_url")
    val licenseDerivativeSourceUrl: String? = null,
    @SerialName("license_object_url")
    val licenseObjectUrl: String? = null,
    @SerialName("license_title")
    val licenseTitle: String? = null,
    @SerialName("style")
    val style: String? = null,
    @SerialName("uuid")
    val uuid: String? = null
)