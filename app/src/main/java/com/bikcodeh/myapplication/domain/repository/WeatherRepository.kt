package com.bikcodeh.myapplication.domain.repository

import com.bikcodeh.myapplication.data.remote.dto.WeatherObjectDTO
import com.bikcodeh.myapplication.domain.commons.Result

interface WeatherRepository {

    suspend fun getWeather(city: String): Result<WeatherObjectDTO>
}