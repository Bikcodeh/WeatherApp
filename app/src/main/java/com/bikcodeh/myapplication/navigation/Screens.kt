package com.bikcodeh.myapplication.navigation

sealed class Screens(val route: String) {
    object Splash: Screens(route = "splash_screen")
    object Home: Screens(route = "home_screen")
    object About: Screens(route = "about_screen")
    object Favorite: Screens(route = "favorite_screen")
    object Search: Screens(route = "search_screen")
    object Settings: Screens(route = "settings_screen")
}
