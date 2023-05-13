package com.bikcodeh.myapplication.domain.repository

import com.bikcodeh.myapplication.data.remote.dto.currentcondition.CurrentConditionResponseDTO
import com.bikcodeh.myapplication.domain.commons.Result

interface WeatherRepository {

    suspend fun getWeather(cityKey: String): Result<CurrentConditionResponseDTO>
    suspend fun findCurrentGeoPosition(lat: String, lon: String): Result<CurrentConditionResponseDTO>
}