package com.example.bookcabincodetest

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * App color palette definition
 */
object BookCabinColors {
    val Orange = Color(0xFFFF6600) // Primary Color
    val DarkOrange = Color(0xFFE05A00) // Darker variant of Orange
    val DarkBlue = Color(0xFF001F4D) // Secondary Color
    val DarkerBlue = Color(0xFF001838) // Darker variant of Dark Blue
    val White = Color.White
    val LightGray = Color(0xFFFAFAFA)
    val Gray = Color(0xFFE0E0E0)
    val DarkGray = Color(0xFF757575)
    val Black = Color(0xFF000000)
}

private val LightColors = lightColors(
    primary = BookCabinColors.Orange,
    primaryVariant = BookCabinColors.DarkOrange,
    onPrimary = BookCabinColors.White,
    secondary = BookCabinColors.DarkBlue,
    secondaryVariant = BookCabinColors.DarkerBlue,
    onSecondary = BookCabinColors.White,
    background = BookCabinColors.White,
    surface = BookCabinColors.LightGray,
    onBackground = BookCabinColors.Black,
    onSurface = BookCabinColors.Black
)

private val DarkColors = darkColors(
    primary = BookCabinColors.Orange,
    primaryVariant = BookCabinColors.DarkOrange,
    onPrimary = BookCabinColors.White,
    secondary = BookCabinColors.DarkBlue,
    secondaryVariant = BookCabinColors.DarkerBlue,
    onSecondary = BookCabinColors.White,
    background = BookCabinColors.White,
    surface = BookCabinColors.LightGray,
    onBackground = BookCabinColors.Black,
    onSurface = BookCabinColors.Black
)

/**
 * App shape definitions
 */
val BookCabinShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)

/**
 * BookCabinTheme composable that sets up the MaterialTheme for the application
 */
@Composable
fun BookCabinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colors = colors,
        shapes = BookCabinShapes,
        typography = Typography,
        content = content
    )
}
