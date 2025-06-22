package com.example.bookcabincodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookcabincodetest.components.BookCabinButton
import com.example.bookcabincodetest.components.BookCabinInputField
import com.example.bookcabincodetest.viewmodel.PassengerViewModel

@Composable
fun OnlineCheckInScreen(
    viewModel: PassengerViewModel,
    onContinue: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Observe the passenger data from the ViewModel using LiveData
    val passenger by viewModel.passenger.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .padding(horizontal = 24.dp), // Using themed color
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Title
        Column (
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        ) {
            Text(
                text = "ONLINE\nCHECK-IN",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 24.dp),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(60.dp))
            // PNR Field
            Text(
                text = "PNR",
                color = Color.White,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxWidth()
            )
            BookCabinInputField(
                value = passenger?.pnr ?: "",
                onValueChange = { viewModel.updatePnr(it) }
            )
            // Last Name Field
            Text(
                text = "Last Name",
                color = Color.White,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxWidth()
            )

            BookCabinInputField(
                value = passenger?.lastName ?: "",
                onValueChange = { viewModel.updateLastName(it) },
                imeAction = ImeAction.Done
            )
        }

        // Continue Button
        BookCabinButton(onContinue, enabled = viewModel.isCheckInFormComplete(), text = "Continue")
    }
}
