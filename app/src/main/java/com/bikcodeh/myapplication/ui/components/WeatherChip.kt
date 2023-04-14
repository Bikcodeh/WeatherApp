package com.bikcodeh.myapplication.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.theme.textColor
import com.bikcodeh.myapplication.ui.theme.yellow

@Composable
fun WeatherTextButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    TextButton(modifier = modifier, onClick = onClick) {
        Text(
            text = stringResource(id = title), style = MaterialTheme.typography.bodyLarge,
            color = if (isSelected) yellow else textColor
        )
    }
}

@Preview
@Composable
fun WeatherTextButtonPreviewSelected() {
    WeatherTextButton(title = R.string.tomorrow, onClick = {}, isSelected = true)
}

@Preview
@Composable
fun WeatherTextButtonPreview() {
    WeatherTextButton(
        isSelected = false,
        title = R.string.tomorrow,
        onClick = {}
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WeatherTextButtonPreviewDark() {
    WeatherTextButton(
        isSelected = false,
        title = R.string.tomorrow,
        onClick = {}
    )
}