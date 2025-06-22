package com.example.bookcabincodetest.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookcabincodetest.BookCabinColors

/**
 * Standard button component for BookCabin app
 *
 * @param onClick Action to perform when button is clicked
 * @param text Text to display on the button
 * @param modifier Modifier for customizing the component
 * @param enabled Whether the button is enabled
 * @param fullWidth Whether the button should take full width
 */
@Composable
fun BookCabinButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    fullWidth: Boolean = true
) {
    val buttonModifier = if (fullWidth) {
        modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    } else {
        modifier.padding(vertical = 8.dp)
    }

    Button(
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        modifier = buttonModifier,
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = BookCabinColors.White,
            disabledBackgroundColor = BookCabinColors.Gray,
            disabledContentColor = BookCabinColors.DarkGray
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}