package com.example.bookcabincodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookcabincodetest.components.BookCabinButton
import com.example.bookcabincodetest.viewmodel.PassengerViewModel

@Composable
fun CheckInConfirmationScreen(
    viewModel: PassengerViewModel,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Observe the passenger data from the ViewModel using LiveData
    val passenger by viewModel.passenger.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Title
        Column (
            modifier = Modifier.padding(top = 100.dp)
        ) {
            Text(
                text = "CHECK-IN",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 24.dp,bottom = 24.dp),
                style = MaterialTheme.typography.h1
            )

            // Passenger Name
            Text(
                text = "${passenger?.firstName} ${passenger?.lastName}",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2
            )

            // Flight Information
            Text(
                text = "Flight ${passenger?.flightNumber} ${passenger?.origin} to ${passenger?.destination}",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )

        }

        // View Boarding Pass Button
        BookCabinButton(
            onClick = onConfirm,
            text = "Check in",
        )
    }
}
