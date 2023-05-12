package com.bikcodeh.myapplication.ui.screens.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.bikcodeh.myapplication.domain.commons.fold
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import com.bikcodeh.myapplication.ui.util.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: DispatcherProvider
) : MVIViewModel<
        HomeUiState, HomeEffect, HomeEvent>(dispatcher = dispatcher) {

    private fun getWeather(city: String) {
        viewModelScope.launch(dispatcher.io) {
            weatherRepository.getWeather(city)
                .fold(
                    onSuccess = {

                    },
                    onError = {

                    }
                )
        }
    }

    override fun setInitialState(): HomeUiState = HomeUiState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetWeather -> getWeather(event.city)
        }
    }
}