package com.bikcodeh.myapplication.data.remote.dto.currentcondition


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDTO(
    @Json(name = "Direction")
    val direction: DirectionDTO?,
    @Json(name = "Speed")
    val speed: SpeedDTO?
)