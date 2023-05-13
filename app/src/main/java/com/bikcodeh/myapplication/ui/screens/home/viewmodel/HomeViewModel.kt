package com.bikcodeh.myapplication.ui.screens.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.bikcodeh.myapplication.domain.commons.Failure
import com.bikcodeh.myapplication.domain.commons.fold
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import com.bikcodeh.myapplication.mocks.currentConditionMock
import com.bikcodeh.myapplication.ui.util.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: DispatcherProvider
) : MVIViewModel<HomeEffect, HomeEvent>(dispatcher = dispatcher) {

    private val _viewState = MutableStateFlow(
        HomeUiState(
            data = currentConditionMock
        )
    )
    val viewState: StateFlow<HomeUiState> get() = _viewState.asStateFlow()


    private fun getWeather() {
        setEffect { HomeEffect.Loading(true) }
        viewModelScope.launch(dispatcher.io) {
            weatherRepository.findCurrentGeoPosition(lat = "3.4430794", lon = "-76.5393492")
                .fold(
                    onSuccess = {
                        setEffect { HomeEffect.Loading(false) }
                        _viewState.value = _viewState.value.copy(data = it)
                    },
                    onError = {
                        setEffect { HomeEffect.Loading(false) }
                        setEffect { HomeEffect.ShowErrorScreen(Failure.getMessageResId(it)) }
                    }
                )
        }
    }

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetWeather -> getWeather()
        }
    }
}