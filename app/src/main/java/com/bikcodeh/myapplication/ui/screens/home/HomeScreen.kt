package com.bikcodeh.myapplication.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.data.remote.dto.CoordinateDTO
import com.bikcodeh.myapplication.domain.commons.Failure
import com.bikcodeh.myapplication.ui.components.ErrorScreen
import com.bikcodeh.myapplication.ui.screens.home.components.HomeTopBar
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEffect
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEvent
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeViewModel
import com.bikcodeh.myapplication.ui.util.Permissions
import com.bikcodeh.myapplication.ui.util.Util
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToPermission: () -> Unit,
    onFiveDaysForecast: () -> Unit
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    var errorLocation by remember { mutableStateOf(false) }
    var getCoordinates by remember { mutableStateOf(true) }

    LaunchedEffect(getCoordinates) {
        if (getCoordinates) {
            Util.getCoordinates(context,
                onError = { failure ->
                    getCoordinates = false
                    if (failure is Failure.NotPermissionException) {
                        navigateToPermission()
                    } else {
                        errorLocation = true
                    }
                }, onSuccess = { lat, lon ->
                    errorLocation = false
                    getCoordinates = false
                    //homeViewModel.sendEvent { HomeEvent.SetCoordinate(CoordinateDTO(lat, lon)) }
                    //homeViewModel.sendEvent { HomeEvent.GetWeather(lat, lon) }
                })
        }
    }

    DisposableEffect(key1 = true) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                if (!Permissions.hasLocationPermission(context)) {
                    navigateToPermission()
                }
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
    val state by homeViewModel.viewState.collectAsStateWithLifecycle()
    val effect by homeViewModel.effects.receiveAsFlow().collectAsStateWithLifecycle(
        initialValue = HomeEffect.Loading(false)
    )

    if (errorLocation) {
        ErrorScreen(message = stringResource(id = R.string.error_not_location)) {
            getCoordinates = true
        }
    } else {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            HomeTopBar(
                modifier = Modifier.statusBarsPadding()
            )
        }) { paddingValues ->
            HomeContent(
                state = state, effect = effect, paddingValues = paddingValues, onRetry = {
                    homeViewModel.coordinate.value?.let { coordinate ->
                        homeViewModel.sendEvent {
                            HomeEvent.GetWeather(
                                coordinate.latitude,
                                coordinate.longitude
                            )
                        }
                    }
                },
                onFiveDaysForecast = onFiveDaysForecast
            )
        }
    }
}