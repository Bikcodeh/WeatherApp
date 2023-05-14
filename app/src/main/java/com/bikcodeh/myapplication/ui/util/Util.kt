package com.bikcodeh.myapplication.ui.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.bikcodeh.myapplication.R
import com.google.android.gms.location.LocationServices

object Util {

    fun getCoordinates(context: Context, onSuccess: (String, String) -> Unit, onError: () -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onError()
            return
        }
        LocationServices.getFusedLocationProviderClient(context).lastLocation
            .addOnSuccessListener { location ->
                onSuccess(location.latitude.toString(), location.longitude.toString())
            }
    }

    enum class WeatherButtons(val text: Int) {
        TODAY(R.string.today),
        TOMORROW(R.string.tomorrow),
        NEXT_FIVE_DAYS(R.string.next_five_days)
    }
}