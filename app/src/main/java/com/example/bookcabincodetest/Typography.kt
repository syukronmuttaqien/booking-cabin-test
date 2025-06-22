package com.example.bookcabincodetest

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * BookCabin typography definitions following brand guidelines
 * Using Sans-serif font family (Roboto on Android) for consistency
 */

val Typography = Typography(
    defaultFontFamily = FontFamily.SansSerif,

    // Large titles
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),

    // Screen headers
    h2 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
    ),

    // Section headers
    h3 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
    ),

    // Sub-section headers
    h4 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    ),

    h5 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),

    h6 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
    ),

    // Used for boarding pass info
    subtitle1 = TextStyle(
        color = BookCabinColors.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
    ),

    // Used for flight details
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),

    // Main text body
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    // Secondary text and form fields
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),

    // Used for buttons
    button = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp, // Reduced from 24sp for better usability
    ),

    // Small print and disclaimers
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),

    // Form labels and small headers
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)
