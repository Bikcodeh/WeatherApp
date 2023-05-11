package com.bikcodeh.myapplication.data.remote.service

import com.bikcodeh.myapplication.data.remote.dto.WeatherObjectDTO
import com.bikcodeh.myapplication.domain.commons.Result
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET("data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "standard",
    ): Result<WeatherObjectDTO>
}