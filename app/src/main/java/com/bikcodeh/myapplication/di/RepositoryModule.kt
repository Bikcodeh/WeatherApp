package com.bikcodeh.myapplication.di

import com.bikcodeh.myapplication.data.remote.service.WeatherApi
import com.bikcodeh.myapplication.data.repository.WeatherRepositoryImpl
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesWeatherRepository(
        weatherApi: WeatherApi,
        dispatcherProvider: DispatcherProvider
    ): WeatherRepository = WeatherRepositoryImpl(weatherApi, dispatcherProvider)
}