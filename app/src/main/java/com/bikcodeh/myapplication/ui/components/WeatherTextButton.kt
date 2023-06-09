package com.bikcodeh.myapplication.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.theme.textColor
import com.bikcodeh.myapplication.ui.theme.yellow

@Composable
fun WeatherTextButton(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    colorSelected: Color = yellow,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = !isSelected
    ) {
        Text(
            text = title, style = MaterialTheme.typography.bodyLarge,
            color = if (isSelected) colorSelected else textColor
        )
    }
}

@Preview
@Composable
fun WeatherTextButtonPreviewSelected() {
    WeatherTextButton(title = "Tomorrow", onClick = {}, isSelected = true)
}

@Preview
@Composable
fun WeatherTextButtonPreview() {
    WeatherTextButton(
        isSelected = false,
        title = "Tomorrow",
        onClick = {}
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WeatherTextButtonPreviewDark() {
    WeatherTextButton(
        isSelected = false,
        title = "Tomorrow",
        onClick = {}
    )
}