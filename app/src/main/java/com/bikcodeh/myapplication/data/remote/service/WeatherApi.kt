package com.bikcodeh.myapplication.data.remote.service

import com.bikcodeh.myapplication.data.remote.dto.currentcondition.CurrentConditionResponseDTO
import com.bikcodeh.myapplication.data.remote.dto.geoposition.GeoPositionDTO
import com.bikcodeh.myapplication.data.remote.dto.hourly.HourlyResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET("locations/v1/cities/geoposition/search")
    suspend fun findCurrentGeoPosition(
        @Query("q") query: String
    ): Response<GeoPositionDTO>

    @GET("currentconditions/v1/{locationKey}")
    suspend fun getCurrentConditions(
        @Path("locationKey") locationKey: String
    ): Response<List<CurrentConditionResponseDTO>>

    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    suspend fun getHourlyForecast(
        @Path("locationKey") locationKey: String
    ): Response<HourlyResponseDTO>
}