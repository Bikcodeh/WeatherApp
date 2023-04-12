package com.bikcodeh.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bikcodeh.myapplication.R

val WeatherFonts = FontFamily(
    Font(R.font.nunito_light, weight = FontWeight.Light),
    Font(R.font.nunito_medium, weight = FontWeight.Medium),
    Font(R.font.nunito_regular, weight = FontWeight.Normal),
    Font(R.font.nunito_bold, weight = FontWeight.Bold)
)

val WeatherTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        letterSpacing = 0.em,
    ),
    displayMedium = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Light,
        fontSize = 45.sp,
        letterSpacing = 0.em,
    ),
    displaySmall = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        letterSpacing = 0.em,
    ),
    headlineLarge = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        letterSpacing = 0.01.em,
    ),
    headlineMedium = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.em,
    ),
    headlineSmall = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        letterSpacing = 0.15.em,
    ),
    titleLarge = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.01.em
    ),
    titleMedium = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.15.em,
    ),
    titleSmall = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.09.em

    ),
    labelLarge = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        letterSpacing = 0.02.em
    ),
    labelMedium = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.em
    ),
    labelSmall = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.5.em
    ),
    bodyLarge = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.03.em
    ),
    bodyMedium = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.em
    ),
    bodySmall = TextStyle(
        fontFamily = WeatherFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.02.em
    )
)