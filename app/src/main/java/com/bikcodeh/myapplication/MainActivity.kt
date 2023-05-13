@file:OptIn(ExperimentalPermissionsApi::class)

package com.bikcodeh.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bikcodeh.myapplication.navigation.Screens
import com.bikcodeh.myapplication.navigation.SetupNavGraph
import com.bikcodeh.myapplication.ui.theme.WeatherAppTheme
import com.bikcodeh.myapplication.ui.util.Permissions
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            navHostController = rememberNavController()
            WeatherAppTheme {
                val startDestination = if (Permissions.hasLocationPermission(this@MainActivity)) {
                    Screens.Home.route
                } else {
                    Screens.Permission.route
                }
                SetupNavGraph(
                    navController = navHostController,
                    startDestination = startDestination,
                )
            }
        }
    }
}