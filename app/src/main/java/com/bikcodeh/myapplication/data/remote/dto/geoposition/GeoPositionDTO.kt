package com.bikcodeh.myapplication.data.remote.dto.geoposition

import com.squareup.moshi.Json

data class GeoPositionDTO(
    @Json(name = "Key") val key: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String
)
