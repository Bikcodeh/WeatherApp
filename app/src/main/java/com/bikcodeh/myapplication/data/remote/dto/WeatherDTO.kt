package com.bikcodeh.myapplication.data.remote.dto

data class WeatherDTO(
    val city: CityDTO,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItemDTO>,
    val message: Double
)