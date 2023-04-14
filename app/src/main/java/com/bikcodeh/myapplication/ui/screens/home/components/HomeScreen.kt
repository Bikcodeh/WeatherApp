package com.bikcodeh.myapplication.ui.screens.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.components.CardHeader
import com.bikcodeh.myapplication.ui.components.WeatherTextButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var todayForecastSelected by remember { mutableStateOf(true) }
    var tomorrowForecastSelected by remember { mutableStateOf(false) }
    var nextDaysForecastSelected by remember { mutableStateOf(false) }

    Scaffold(topBar = { HomeTopBar() }, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            CardHeader(
                date = "Sat, 3 Aug",
                temperature = "30 °c",
                location = "California, USA 90145"
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
        }
    }
}