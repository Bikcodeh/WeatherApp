package com.bikcodeh.myapplication.ui.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import com.bikcodeh.myapplication.domain.commons.fold
import com.bikcodeh.myapplication.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    private val _effectChannel = Channel<HomeEffect>(Channel.UNLIMITED)
    val effects = _effectChannel.receiveAsFlow()

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
}