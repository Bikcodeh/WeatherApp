package com.bikcodeh.myapplication.ui.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bikcodeh.myapplication.R

@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        title = {
            Text(text = stringResource(R.string.weather_forecast_title))
        }
    )
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar()
}

@Preview(uiMode =  UI_MODE_NIGHT_YES)
@Composable
private fun HomeTopBarPreviewDark() {
    HomeTopBar()
}

