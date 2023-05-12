package com.bikcodeh.myapplication.data.remote.service

import com.bikcodeh.myapplication.data.remote.dto.WeatherObjectDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET("data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "standard",
    ): Response<WeatherObjectDTO>
}