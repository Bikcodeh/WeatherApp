package com.bikcodeh.myapplication.data.remote.dto

data class WeatherItemDTO(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feels_like: FeelsLikeDTO,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempDTO,
    val weather: List<WeatherObjectDTO>
)