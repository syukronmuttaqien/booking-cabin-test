package com.example.bookcabincodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookcabincodetest.components.BookCabinButton
import com.example.bookcabincodetest.components.BookCabinInputField
import com.example.bookcabincodetest.viewmodel.PassengerViewModel

@Composable
fun PassengerDetailsScreen(
    viewModel: PassengerViewModel,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Observe the passenger data from the ViewModel using LiveData
    val passenger by viewModel.passenger.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(space = 4.dp, Alignment.Top),
        ) {
            // Header
            Text(
                text = "Passenger\nDetails",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
            )

            // Passenger Name and Flight Info
            Text(
                text = "${passenger?.firstName ?: ""} ${passenger?.lastName ?: ""}",
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = "${passenger?.flightNumber} ${passenger?.origin} to ${passenger?.destination}",
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Required Information Info
            Text(
                text = "Passport information is required",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF47023),
                        shape = MaterialTheme.shapes.medium,
                    )
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Description
            Text(
                fontSize = 24.sp,
                text = "Please enter the required document details below",
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Passport Number
            Text(
                text = "Passport Number",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(8.dp))

            BookCabinInputField(
                value = passenger?.passportNumber ?: "",
                onValueChange = { viewModel.updatePassportNumber(it) },
                imeAction = ImeAction.Done
            )
        }

        // Save Button
        BookCabinButton(
            onSave,
            enabled = viewModel.isPassengerDetailsComplete(),
            text = "Save"
        )

    }
}



