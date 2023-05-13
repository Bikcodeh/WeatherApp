package com.bikcodeh.myapplication.data.remote.dto.currentcondition


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TemperatureDTO(
    @Json(name = "Metric")
    val metric: MetricDTO?
)