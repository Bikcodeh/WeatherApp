package com.bikcodeh.myapplication.data.repository

import com.bikcodeh.myapplication.data.remote.dto.currentcondition.CurrentConditionResponseDTO
import com.bikcodeh.myapplication.data.remote.service.WeatherApi
import com.bikcodeh.myapplication.domain.commons.Result
import com.bikcodeh.myapplication.domain.commons.fold
import com.bikcodeh.myapplication.domain.commons.makeSafeRequest
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dispatcherProvider: DispatcherProvider
) : WeatherRepository {
    override suspend fun getWeather(cityKey: String): Result<CurrentConditionResponseDTO> {
        val data = withContext(dispatcherProvider.io) {
            makeSafeRequest {
                weatherApi.getCurrentConditions(locationKey = cityKey)
            }
        }
        return data.fold(
            onSuccess = { Result.Success(it.first()) },
            onError = { Result.Error(it) }
        )
    }

    override suspend fun findCurrentGeoPosition(
        lat: String,
        lon: String
    ): Result<CurrentConditionResponseDTO> {
        return withContext(dispatcherProvider.io) {
            makeSafeRequest { weatherApi.findCurrentGeoPosition(query = "$lat,$lon") }.fold(
                onSuccess = { getWeather(it.key) },
                onError = { Result.Error(it) }
            )
        }
    }
}