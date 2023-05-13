package com.bikcodeh.myapplication.data.remote.dto.currentcondition


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DirectionDTO(
    @Json(name = "Degrees")
    val degrees: Int?,
    @Json(name = "English")
    val english: String?,
    @Json(name = "Localized")
    val localized: String?
)