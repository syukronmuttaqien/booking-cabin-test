package com.example.bookcabincodetest.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bookcabincodetest.BookCabinColors

/**
 * A standardized input field component for BookCabin app
 *
 * @param value The current text value
 * @param onValueChange Callback when text changes
 * @param label Label displayed for the input field
 * @param modifier Modifier for customizing the component
 * @param placeholder Optional placeholder text
 * @param isError Whether the field is in an error state
 * @param errorMessage Error message to display when isError is true
 * @param keyboardType Keyboard type to show
 * @param imeAction IME action for the keyboard
 * @param keyboardActions Actions to perform on IME actions
 */
@Composable
fun BookCabinInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    label:  @Composable() (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        placeholder = placeholder?.let { { Text(text = it) } },
        modifier = modifier
            .fillMaxWidth(),
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = BookCabinColors.Gray,
            errorBorderColor = MaterialTheme.colors.error,
            backgroundColor = MaterialTheme.colors.background,
        ),
        singleLine = true,
    )

    if (isError && !errorMessage.isNullOrBlank()) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}
