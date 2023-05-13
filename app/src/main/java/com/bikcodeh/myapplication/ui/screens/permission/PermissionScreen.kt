package com.bikcodeh.myapplication.ui.screens.permission

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.util.extension.openAppSettings
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(
    modifier: Modifier = Modifier,
    permission: String,
    onGranted: () -> Unit,
    permissionTextProvider: PermissionTextProvider
) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(permission)

    val isDeclined = remember { derivedStateOf { permissionState.status.shouldShowRationale } }

    if (permissionState.status.isGranted) {
        onGranted()
    } else {
        val textToShow =
            permissionTextProvider.getDescription(isPermanentlyDeclined = isDeclined.value)

        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Divider()
                    Text(
                        text = if (isDeclined.value) {
                            context.getString(R.string.label_grant_permission)
                        } else {
                            context.getString(R.string.option_ok)
                        },
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (isDeclined.value) {
                                    (context as Activity).openAppSettings()
                                } else {
                                    permissionState.launchPermissionRequest()
                                }
                            }
                            .padding(16.dp)
                    )
                }
            },
            title = { Text(text = context.getString(R.string.label_permission_required)) },
            text = { Text(text = context.getString(textToShow)) },
            modifier = modifier
        )
    }
}

interface PermissionTextProvider {
    fun getDescription(isPermanentlyDeclined: Boolean): Int
}

class LocationTextProvider: PermissionTextProvider {
    override fun getDescription(isPermanentlyDeclined: Boolean): Int {
        return if(isPermanentlyDeclined) {
            R.string.permission_permanent_description
        } else {
            R.string.permission_description
        }
    }
}