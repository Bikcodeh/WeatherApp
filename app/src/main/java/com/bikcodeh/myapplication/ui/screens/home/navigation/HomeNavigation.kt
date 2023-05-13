package com.bikcodeh.myapplication.ui.screens.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bikcodeh.myapplication.navigation.Screens
import com.bikcodeh.myapplication.ui.screens.home.HomeScreen
import com.bikcodeh.myapplication.ui.screens.home.viewmodel.HomeViewModel

fun NavGraphBuilder.homeRoute(
    navigateToPermission: () -> Unit
) {
    composable(route = Screens.Home.route) {
        val homeViewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(homeViewModel = homeViewModel, navigateToPermission = navigateToPermission)
    }
}