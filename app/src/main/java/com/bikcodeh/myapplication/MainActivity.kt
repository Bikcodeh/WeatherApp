package com.bikcodeh.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bikcodeh.myapplication.navigation.SetupNavGraph
import com.bikcodeh.myapplication.ui.screens.home.components.HomeScreen
import com.bikcodeh.myapplication.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    private var onReady = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { onReady }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            navHostController = rememberNavController()
            WeatherAppTheme {
                SetupNavGraph(navController = navHostController, onReady = { onReady = false })
            }
        }
    }
}