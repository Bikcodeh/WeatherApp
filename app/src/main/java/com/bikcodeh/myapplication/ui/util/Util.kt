package com.bikcodeh.myapplication.ui.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.domain.commons.Failure
import com.google.android.gms.location.LocationServices
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Locale

object Util {

    fun getCoordinates(context: Context, onSuccess: (String, String) -> Unit, onError: (Failure) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onError(Failure.NotPermissionException())
            return
        }
        LocationServices.getFusedLocationProviderClient(context).lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    onSuccess(location.latitude.toString(), location.longitude.toString())
                } else {
                    onError(Failure.NotLocationException())
                }
            }
    }

    enum class WeatherButtons(val text: Int) {
        TODAY(R.string.today),
        TOMORROW(R.string.tomorrow),
        NEXT_FIVE_DAYS(R.string.next_five_days)
    }

    fun formatDate(dateString: String): String {
        val dateFormat = SimpleDateFormat("EEEE, d MMM", Locale.getDefault())
        val date =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault()).parse(dateString)
        return dateFormat.format(date)
    }

    /* low (1-2)
    moderate (3-5)
    high (6-7)
    very high (8-10)
    extreme (11 and above). */

    fun getRangeUvIndex(value: Int): Float {
        return when {
            value in 1..2 -> 0.1f
            value in 3..5 -> 0.5f
            value in 6..7 -> 0.6f
            value in 8..10 -> 0.8f
            value > 10 -> 0.95f
            else -> 0.01f
        }
    }
}