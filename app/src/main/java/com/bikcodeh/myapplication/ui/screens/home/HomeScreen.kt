package com.bikcodeh.myapplication.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bikcodeh.myapplication.ui.screens.home.components.HomeTopBar
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEffect
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeEvent
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeViewModel
import com.bikcodeh.myapplication.ui.util.Permissions
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToPermission: () -> Unit
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(Unit) {
        //homeViewModel.sendEvent { HomeEvent.GetWeather("seattle") }
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

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        HomeTopBar(
            modifier = Modifier.statusBarsPadding()
        )
    }) { paddingValues ->
        HomeContent(state = state, effect = effect, paddingValues = paddingValues, onRetry = {
            homeViewModel.sendEvent { HomeEvent.GetWeather("seattle") }
        })
    }
}