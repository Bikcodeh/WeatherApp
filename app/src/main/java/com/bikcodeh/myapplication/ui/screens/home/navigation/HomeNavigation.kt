package com.bikcodeh.myapplication.ui.screens.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bikcodeh.myapplication.navigation.Screens
import com.bikcodeh.myapplication.ui.screens.home.components.HomeScreen

fun NavGraphBuilder.homeRoute(
    onReady: () -> Unit
) {
    composable(route = Screens.Home.route) {
        HomeScreen()
        onReady()
    }
}