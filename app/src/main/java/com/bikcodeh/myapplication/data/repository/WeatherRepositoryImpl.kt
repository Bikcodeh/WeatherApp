package com.bikcodeh.myapplication.data.repository

import com.bikcodeh.myapplication.data.remote.dto.WeatherObjectDTO
import com.bikcodeh.myapplication.data.remote.service.WeatherApi
import com.bikcodeh.myapplication.domain.commons.makeSafeRequest
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import com.bikcodeh.myapplication.domain.commons.Result
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(city: String): Result<WeatherObjectDTO> {
        return makeSafeRequest { weatherApi.getWeather(query = city) }
    }
}