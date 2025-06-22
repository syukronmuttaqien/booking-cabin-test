package com.example.bookcabincodetest.model

data class PassengerModel(
    var pnr: String = "",
    var lastName: String = "",
    var firstName: String = "First",
    var flightNumber: String = "SQ 527",
    var origin: String = "Singapore",
    var destination: String = "Tokyo",
    var passportNumber: String = "",
    var seatNumber: String = "22A",
    var boardingSection: String = "S22",
    var departureAirport: String = "SIN",
    var arrivalAirport: String = "HNO"
)
