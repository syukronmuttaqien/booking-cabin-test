package com.example.bookcabincodetest.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bookcabincodetest.BookCabinColors

/**
 * Standard TopAppBar component for BookCabin app
 *
 * @param title Text to display in the center of the app bar
 * @param canNavigateBack Whether to show a back button
 * @param onNavigateBack Action to perform when back button is clicked
 */
@Composable
fun AppTopBar(
    title: String,
    canNavigateBack: Boolean = false,
    onNavigateBack: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = BookCabinColors.White,
                style = MaterialTheme.typography.h5
            )
        },
        navigationIcon = if (canNavigateBack) {
            {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Navigate back",
                        tint = BookCabinColors.White
                    )
                }
            }
        } else null,
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    )
}
