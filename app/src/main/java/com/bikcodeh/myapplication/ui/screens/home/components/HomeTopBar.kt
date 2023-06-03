package com.bikcodeh.myapplication.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    elevation: Dp = 0.dp,
    onSearchClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        title = {
            Text(text = stringResource(R.string.weather_forecast_title))
        },
        actions = {
            Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier
                .clip(
                    CircleShape
                )
                .clickable {
                    onSearchClick()
                })
            Icon(
                Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onMenuClick() })

        }
    )
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar()
}
