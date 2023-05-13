package com.bikcodeh.myapplication.data.remote.dto.hourly


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyResponseDTO(
    @Json(name = "DateTime")
    val dateTime: String?,
    @Json(name = "EpochDateTime")
    val epochDateTime: Int?,
    @Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @Json(name = "IconPhrase")
    val iconPhrase: String?,
    @Json(name = "IsDaylight")
    val isDaylight: Boolean?,
    @Json(name = "Link")
    val link: String?,
    @Json(name = "MobileLink")
    val mobileLink: String?,
    @Json(name = "PrecipitationProbability")
    val precipitationProbability: Int?,
    @Json(name = "Temperature")
    val temperature: HourlyTemperatureDTO?,
    @Json(name = "WeatherIcon")
    val weatherIcon: Int?
)