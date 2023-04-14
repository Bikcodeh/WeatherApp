package com.bikcodeh.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bikcodeh.myapplication.ui.screens.home.components.HomeScreen
import com.bikcodeh.myapplication.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                HomeScreen()
            }
        }
    }
}