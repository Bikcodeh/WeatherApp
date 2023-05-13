package com.bikcodeh.myapplication.data.remote.dto.hourly


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyTemperatureDTO(
    @Json(name = "Unit")
    val unit: String?,
    @Json(name = "UnitType")
    val unitType: Int?,
    @Json(name = "Value")
    val value: Int?
)