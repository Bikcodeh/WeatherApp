package com.bikcodeh.myapplication.ui.screens.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.components.CardHeader
import com.bikcodeh.myapplication.ui.components.WeatherItem
import com.bikcodeh.myapplication.ui.components.WeatherTextButton
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEffect
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEvent
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    LaunchedEffect(key1 = true) {
        homeViewModel.sendEvent { HomeEvent.GetWeather("seattle") }
    }
    val state by homeViewModel.viewState.collectAsState()
    val effect by homeViewModel.effects.receiveAsFlow()
        .collectAsState(initial = HomeEffect.Loading(true))

    var todayForecastSelected by remember { mutableStateOf(true) }
    var tomorrowForecastSelected by remember { mutableStateOf(false) }
    var nextDaysForecastSelected by remember { mutableStateOf(false) }

    Scaffold(topBar = { HomeTopBar() }, modifier = Modifier.fillMaxSize()) {

        if (effect is HomeEffect.Loading && (effect as HomeEffect.Loading).isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
                    .verticalScroll(rememberScrollState())
            ) {

                CardHeader(
                    date = "Sat, 3 Aug",
                    temperature = "30 °c",
                    location = state.data?.weatherText ?: "NULLL"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp)
                ) {
                    WeatherTextButton(
                        isSelected = todayForecastSelected,
                        title = R.string.today,
                        onClick = {
                            todayForecastSelected = true
                            tomorrowForecastSelected = false
                            nextDaysForecastSelected = false
                        })
                    WeatherTextButton(
                        isSelected = tomorrowForecastSelected,
                        title = R.string.tomorrow,
                        onClick = {
                            todayForecastSelected = false
                            tomorrowForecastSelected = true
                            nextDaysForecastSelected = false
                        })
                    WeatherTextButton(
                        isSelected = nextDaysForecastSelected,
                        title = R.string.next_five_days,
                        onClick = {
                            todayForecastSelected = false
                            tomorrowForecastSelected = false
                            nextDaysForecastSelected = true
                        })
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    WeatherItem(
                        temperature = "26",
                        time = "10 AM",
                        weatherIcon = R.drawable.ic_blizzard
                    )
                    WeatherItem(
                        temperature = "20",
                        time = "2 PM",
                        weatherIcon = R.drawable.ic_blowing_snow
                    )
                    WeatherItem(
                        temperature = "32",
                        time = "9 AM",
                        weatherIcon = R.drawable.ic_heavy_rain
                    )
                    WeatherItem(
                        temperature = "26",
                        time = "10 AM",
                        weatherIcon = R.drawable.ic_blizzard
                    )
                    WeatherItem(
                        temperature = "20",
                        time = "2 PM",
                        weatherIcon = R.drawable.ic_blowing_snow
                    )
                    WeatherItem(
                        temperature = "32",
                        time = "9 AM",
                        weatherIcon = R.drawable.ic_heavy_rain
                    )
                }
            }
        }
    }
}