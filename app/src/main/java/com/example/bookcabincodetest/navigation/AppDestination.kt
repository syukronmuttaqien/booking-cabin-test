package com.example.bookcabincodetest.navigation

/**
 * Sealed class defining all navigation destinations in the app
 * This approach provides type safety and better organization for navigation routes
 */
sealed class AppDestination(val route: String) {
    object OnlineCheckIn : AppDestination("online_check_in")
    object PassengerDetails : AppDestination("passenger_details")
    object CheckInConfirmation : AppDestination("check_in_confirmation")
    object BoardingPass : AppDestination("boarding_pass")

    companion object {
        fun fromRoute(route: String?): AppDestination {
            return when(route) {
                OnlineCheckIn.route -> OnlineCheckIn
                PassengerDetails.route -> PassengerDetails
                CheckInConfirmation.route -> CheckInConfirmation
                BoardingPass.route -> BoardingPass
                else -> OnlineCheckIn
            }
        }
    }
}
