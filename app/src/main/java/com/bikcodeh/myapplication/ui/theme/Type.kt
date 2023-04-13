package com.bikcodeh.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.bikcodeh.myapplication.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight

val NunitoLight = FontFamily(
    Font(R.font.nunito_light, FontWeight.W300),
)

val NunitoMedium = FontFamily(
    Font(R.font.nunito_medium, FontWeight.W500),
)

val NunitoRegular = FontFamily(
    Font(R.font.nunito_regular, FontWeight.W400),
)

val NunitoBold = FontFamily(
    Font(R.font.nunito_bold, FontWeight.W700),
)

val weatherTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 60.sp,
        letterSpacing = (-1.5).sp
    ),
    displayMedium = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 48.sp,
        letterSpacing = (-0.5).sp
    ),
    displaySmall = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 34.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 24.sp,
        letterSpacing = (-0.5).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 18.sp,
        letterSpacing = 0.25.sp
    ),
    titleLarge = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 20.sp,
        letterSpacing = (-0.25).sp
    ),
    titleMedium = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 16.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = NunitoBold,
        fontSize = 14.sp,
        letterSpacing = (0.15).sp
    ),
    bodyLarge = TextStyle(
        fontFamily = NunitoRegular,
        fontSize = 16.sp,
        letterSpacing = (0.5).sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = NunitoRegular,
        fontSize = 14.sp,
        letterSpacing = (0.25).sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = NunitoRegular,
        fontSize = 12.sp,
        letterSpacing = (0.4).sp,
        lineHeight = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 14.sp,
        letterSpacing = (0.15).sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W500
    ),
    labelMedium = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 12.sp,
        letterSpacing = (0.4).sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W500
    ),
    labelSmall = TextStyle(
        fontFamily = NunitoMedium,
        fontSize = 10.sp,
        letterSpacing = (0.5).sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W500
    )
)
