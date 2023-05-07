package com.bikcodeh.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.bikcodeh.myapplication.ui.screens.home.navigation.homeRoute

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    onReady: () -> Unit
) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        homeRoute(onReady)
    }
}