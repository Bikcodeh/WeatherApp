package com.bikcodeh.myapplication.mocks

import com.bikcodeh.myapplication.data.remote.dto.currentcondition.CurrentConditionResponseDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.DirectionDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.MetricDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.PressureDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.RealFeelTemperatureDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.SpeedDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.TemperatureDTO
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.WindDTO

val currentConditionMock = CurrentConditionResponseDTO(
    cloudCover = 20,
    epochTime = 2000,
    hasPrecipitation = true,
    indoorRelativeHumidity = 200,
    isDayTime = true,
    localObservationDateTime = "test",
    precipitationType = null,
    pressure = PressureDTO(
        metric = MetricDTO(
            phrase = "test", unit = "metrics", unitType = 2, value = 100.0
        )
    ),
    realFeelTemperature = RealFeelTemperatureDTO(
        metric = MetricDTO(
            phrase = "test", unit = "metrics", unitType = 2, value = 100.0
        )
    ),
    relativeHumidity = 10,
    temperature = TemperatureDTO(
        metric = MetricDTO(
            phrase = "test", unit = "metrics", unitType = 2, value = 100.0
        )
    ),
    uVIndex = 10,
    uVIndexText = "11",
    weatherIcon = 1,
    weatherText = "Como vamos",
    wind = WindDTO(
        direction = DirectionDTO(
            degrees = 1, english = "2", localized = "3"

        ), speed = SpeedDTO(
            metric = MetricDTO(
                phrase = "test", unit = "metrics", unitType = 2, value = 100.0
            )
        )
    )
)