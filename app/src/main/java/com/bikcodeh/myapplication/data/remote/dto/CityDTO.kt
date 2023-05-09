package com.bikcodeh.myapplication.data.remote.dto

data class CityDTO(
    val coord: CoordDTO,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)