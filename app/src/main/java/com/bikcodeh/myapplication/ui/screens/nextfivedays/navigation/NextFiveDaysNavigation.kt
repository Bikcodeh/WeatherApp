package com.bikcodeh.myapplication.ui.screens.nextfivedays.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bikcodeh.myapplication.navigation.Screens
import com.bikcodeh.myapplication.ui.screens.nextfivedays.NextFiveDaysScreen

fun NavGraphBuilder.nextFiveDaysRoute() {
    composable(route = Screens.NextFiveDays.route) {
        NextFiveDaysScreen()
    }
}