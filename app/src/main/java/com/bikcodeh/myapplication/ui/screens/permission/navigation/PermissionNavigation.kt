package com.bikcodeh.myapplication.ui.screens.permission.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bikcodeh.myapplication.navigation.Screens
import com.bikcodeh.myapplication.ui.screens.permission.PermissionScreen
import com.bikcodeh.myapplication.ui.screens.permission.PermissionTextProvider

fun NavGraphBuilder.permissionRoute(
    onGranted: () -> Unit,
    permission: String,
    permissionTextProvider: PermissionTextProvider,
    onReady: () -> Unit
) {
    composable(route = Screens.Permission.route) {
        PermissionScreen(
            permission = permission,
            onGranted = onGranted,
            permissionTextProvider = permissionTextProvider
        )
        onReady()
    }
}