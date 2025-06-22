package com.example.bookcabincodetest.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookcabincodetest.screens.BoardingPassScreen
import com.example.bookcabincodetest.screens.CheckInConfirmationScreen
import com.example.bookcabincodetest.screens.OnlineCheckInScreen
import com.example.bookcabincodetest.screens.PassengerDetailsScreen
import com.example.bookcabincodetest.viewmodel.PassengerViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    passengerViewModel: PassengerViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.OnlineCheckIn.route
    ) {
        composable(AppDestination.OnlineCheckIn.route) {
            Scaffold { paddingValues ->
                OnlineCheckInScreen(
                    viewModel = passengerViewModel,
                    onContinue = { navController.navigate(AppDestination.PassengerDetails.route) },
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }

        composable(AppDestination.PassengerDetails.route) {
            Scaffold { paddingValues ->
                PassengerDetailsScreen(
                    viewModel = passengerViewModel,
                    onSave = { navController.navigate(AppDestination.CheckInConfirmation.route) },
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }

        composable(AppDestination.CheckInConfirmation.route) {
            Scaffold { paddingValues ->
                CheckInConfirmationScreen(
                    viewModel = passengerViewModel,
                    onConfirm = {
                        passengerViewModel.processCheckIn(
                            onSuccess = { navController.navigate(AppDestination.BoardingPass.route) },
                            onError = { /* Handle error - could show a snackbar */ }
                        )
                    },
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }

        composable(AppDestination.BoardingPass.route) {
            Scaffold { paddingValues ->
                BoardingPassScreen(
                    viewModel = passengerViewModel,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}
