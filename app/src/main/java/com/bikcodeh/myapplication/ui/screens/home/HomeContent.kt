package com.bikcodeh.myapplication.ui.screens.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.mocks.currentConditionMock
import com.bikcodeh.myapplication.ui.components.CardHeader
import com.bikcodeh.myapplication.ui.components.ErrorScreen
import com.bikcodeh.myapplication.ui.components.WeatherItem
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEffect
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeUiState

@ExperimentalMaterial3Api
@Composable
fun HomeContent(
    state: HomeUiState,
    effect: HomeEffect,
    onRetry: () -> Unit,
    paddingValues: PaddingValues,
    onFiveDaysForecast: () -> Unit
) {
    val context = LocalContext.current
    //var forecastSelected by remember { mutableStateOf(context.getString(R.string.today)) }

    if (effect is HomeEffect.Loading && effect.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else if (effect is HomeEffect.ShowErrorScreen) {
        ErrorScreen(
            message = context.getString(effect.errorMessage),
            onTryAgain = onRetry
        )
    }
    state.data?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
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
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = R.string.hourly_forecast))
                TextButton(onClick = onFiveDaysForecast) {
                    Text(text = stringResource(id = R.string.next_five_days))
                }
                /*Util.WeatherButtons.values().map { weatherButtonText ->
                    val text = stringResource(id = weatherButtonText.text )
                    WeatherTextButton(
                        isSelected = forecastSelected == text,
                        title = text,
                        onClick = {
                            forecastSelected = text
                            //TODO: Logic to change the data
                        }
                    )
                }*/
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

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    HomeContent(
        state = HomeUiState(
            data = currentConditionMock
        ),
        effect = HomeEffect.Loading(false),
        onRetry = { },
        paddingValues = PaddingValues(),
        onFiveDaysForecast = {}
    )
}