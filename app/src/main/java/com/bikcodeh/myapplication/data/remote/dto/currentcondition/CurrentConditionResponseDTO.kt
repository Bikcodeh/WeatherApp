package com.bikcodeh.myapplication.data.remote.dto.currentcondition


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentConditionResponseDTO(
    @Json(name = "CloudCover")
    val cloudCover: Int?,
    @Json(name = "EpochTime")
    val epochTime: Int?,
    @Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean?,
    @Json(name = "IndoorRelativeHumidity")
    val indoorRelativeHumidity: Int?,
    @Json(name = "IsDayTime")
    val isDayTime: Boolean?,
    @Json(name = "LocalObservationDateTime")
    val localObservationDateTime: String?,
    @Json(name = "PrecipitationType")
    val precipitationType: Any?,
    @Json(name = "Pressure")
    val pressure: PressureDTO?,
    @Json(name = "RealFeelTemperature")
    val realFeelTemperature: RealFeelTemperatureDTO?,
    @Json(name = "RelativeHumidity")
    val relativeHumidity: Int?,
    @Json(name = "Temperature")
    val temperature: TemperatureDTO?,
    @Json(name = "UVIndex")
    val uVIndex: Int?,
    @Json(name = "UVIndexText")
    val uVIndexText: String?,
    @Json(name = "WeatherIcon")
    val weatherIcon: Int?,
    @Json(name = "WeatherText")
    val weatherText: String?,
    @Json(name = "Wind")
    val wind: WindDTO?
)