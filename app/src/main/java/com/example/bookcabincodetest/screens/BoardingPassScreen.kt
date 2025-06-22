package com.example.bookcabincodetest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookcabincodetest.viewmodel.PassengerViewModel
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType

@Composable
fun BoardingPassScreen(
    viewModel: PassengerViewModel,
    modifier: Modifier = Modifier
) {
    // Observe the passenger data from the ViewModel using LiveData
    val passenger by viewModel.passenger.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Title
        Text(
            text = "Boarding\nPass",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.h1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Boarding Pass Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            // Header section with passenger name
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFE8703A), // Orange color as shown in the image
                        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "${passenger?.firstName ?: "JOHN"} ${passenger?.lastName ?: "SMITH"}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.White
                )
            }

            // Middle section with seat info
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                    )
                    .background(Color(0xFFFEF3E7)) // Light cream background
                    .padding(24.dp)

            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(
                                text = "SQ 527",
                                fontSize = 18.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = "S22",
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0A1F44) // Dark blue color
                            )
                        }

                        Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(
                                text = "SEAT",
                                fontSize = 18.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = "22A",
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0A1F44) // Dark blue color
                            )
                        }
                    }
                }
            }

            // Dashed divider
            DashedDivider()

            // Bottom section with barcode
            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp, topStart = 12.dp, topEnd = 12.dp)
                    )
                    .background(Color(0xFFFEF3E7)) // Light cream background
                    .padding(24.dp)

            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "SIN",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0A1F44) // Dark blue color
                        )

                        Text(
                            text = "HNO",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0A1F44) // Dark blue color
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Barcode
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(Color.Transparent)
                            .border(
                                border = BorderStroke(width = 0.dp, color = Color.White),
                                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                            ),
                        contentAlignment = Alignment.TopStart
                    ) {
                        passenger?.flightNumber?.let {
                            Barcode(
                                modifier = Modifier.fillMaxWidth(),
                                width = 300.dp,
                                resolutionFactor = 10, // Optionally, increase the resolution of the generated image
                                type = BarcodeType.CODE_128, // pick the type of barcode you want to render
                                value = it // The textual representation of this code
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DashedDivider(
    color: Color = Color(0xFFE8703A), // Orange color for the dashed line
    thickness: Dp = 1.dp,
    dashLength: Dp = 8.dp,
    gapLength: Dp = 4.dp
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(30) { // Adjust number based on width
            Box(
                modifier = Modifier
                    .width(width = dashLength)
                    .height(height = thickness)
                    .background(color)
            )
            Spacer(modifier = Modifier.width(width = gapLength))
        }
    }
}
