package com.bikcodeh.myapplication.ui.screens.home.viewmodel

import androidx.annotation.StringRes
import com.bikcodeh.myapplication.data.remote.dto.currentcondition.CurrentConditionResponseDTO
import com.bikcodeh.myapplication.domain.commons.ViewEvent
import com.bikcodeh.myapplication.domain.commons.ViewSideEffect
import com.bikcodeh.myapplication.domain.commons.ViewState

sealed class HomeEffect : ViewSideEffect {
    data class ShowErrorScreen(@StringRes val errorMessage: Int) : HomeEffect()
    data class Loading(val isLoading: Boolean) : HomeEffect()
}

sealed class HomeEvent : ViewEvent {
    data class GetWeather(val city: String) : HomeEvent()
}

data class HomeUiState(
    val data: CurrentConditionResponseDTO? = null
) : ViewState