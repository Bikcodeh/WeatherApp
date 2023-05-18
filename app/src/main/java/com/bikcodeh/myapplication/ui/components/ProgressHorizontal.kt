package com.bikcodeh.myapplication.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.bikcodeh.myapplication.ui.theme.md_theme_dark_inversePrimary
import com.bikcodeh.myapplication.ui.theme.md_theme_light_error
import com.bikcodeh.myapplication.ui.theme.md_theme_light_secondary
import com.bikcodeh.myapplication.ui.theme.vivid_mulberry
import com.bikcodeh.myapplication.ui.util.Util

@Composable
fun ProgressHorizontal(
    modifier: Modifier = Modifier,
    uvIndex: Int
) {
    var widthCir = 0f
    Box(modifier = modifier.height(4.dp), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier.height(8.dp).fillMaxWidth()) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                widthCir = size.width
                val strokeWidth = 0f
                val height = size.height - strokeWidth

                drawLine(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            md_theme_dark_inversePrimary,
                            md_theme_light_secondary,
                            vivid_mulberry,
                            md_theme_light_error
                        )
                    ),
                    start = Offset(0f, height / 2),
                    end = Offset(size.width, height / 2),
                    strokeWidth = height,
                    cap = StrokeCap.Round
                )
            }
        }

        Canvas(modifier = Modifier
            .align(Alignment.CenterStart)
            .background(Color.Transparent)
            .zIndex(1f)) {
            drawCircle(
                color = Color.White,
                center = Offset( widthCir * Util.getRangeUvIndex(uvIndex), -0.5f),
                radius = 5f
            )
        }
    }
}

@Preview
@Composable
fun ProgressHorizontalPreview() {
    ProgressHorizontal(uvIndex = 12)
}