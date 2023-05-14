package com.bikcodeh.myapplication.navigation

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.bikcodeh.myapplication.ui.screens.home.navigation.homeRoute
import com.bikcodeh.myapplication.ui.screens.nextfivedays.navigation.nextFiveDaysRoute
import com.bikcodeh.myapplication.ui.screens.permission.LocationTextProvider
import com.bikcodeh.myapplication.ui.screens.permission.navigation.permissionRoute

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    onReady: () -> Unit
) {
    NavHost(navController = navController, startDestination = startDestination) {
        homeRoute(
            onReady = onReady,
            navigateToPermission = {
            navController.navigate(Screens.Permission.route) {
                popUpTo(Screens.Permission.route)
            }
        },
            onFiveDaysForecast = {
                navController.navigate(Screens.NextFiveDays.route)
            })
        permissionRoute(
            onGranted = {
                navController.navigate(Screens.Home.route) {
                    popUpTo(Screens.Home.route)
                }
            },
            permission = Manifest.permission.ACCESS_FINE_LOCATION,
            permissionTextProvider = LocationTextProvider(),
            onReady = onReady
        )
        nextFiveDaysRoute()
    }
}