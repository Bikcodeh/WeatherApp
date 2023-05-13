package com.bikcodeh.myapplication.data.remote.dto.currentcondition


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetricDTO(
    @Json(name = "Phrase")
    val phrase: String?,
    @Json(name = "Unit")
    val unit: String?,
    @Json(name = "UnitType")
    val unitType: Int?,
    @Json(name = "Value")
    val value: Double?
)