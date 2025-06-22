package com.example.bookcabincodetest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookcabincodetest.data.repository.PassengerRepository
import com.example.bookcabincodetest.model.PassengerModel
import kotlinx.coroutines.launch

class PassengerViewModel(
    private val repository: PassengerRepository = PassengerRepository.getInstance()
) : ViewModel() {

    // Expose the passenger data from the repository
    val passenger: LiveData<PassengerModel> = repository.passengerData

    // Update PNR
    fun updatePnr(pnr: String) {
        repository.updatePassengerField { it.copy(pnr = pnr) }
    }

    // Update Last Name
    fun updateLastName(lastName: String) {
        repository.updatePassengerField { it.copy(lastName = lastName) }
    }

    // Update First Name
    fun updateFirstName(firstName: String) {
        repository.updatePassengerField { it.copy(firstName = firstName) }
    }

    // Update Passport Number
    fun updatePassportNumber(passportNumber: String) {
        repository.updatePassengerField { it.copy(passportNumber = passportNumber) }
    }

    // Update the entire passenger model
    fun updatePassenger(passenger: PassengerModel) {
        repository.updatePassenger(passenger)
    }

    // Process check-in with error handling
    fun processCheckIn(onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            if (isPassengerDetailsComplete()) {
                repository.checkInPassenger(onSuccess, onError)
            } else {
                onError("Please complete all required passenger details")
            }
        }
    }

    // Validate if check-in form is complete
    fun isCheckInFormComplete(): Boolean {
        val currentPassenger = passenger.value ?: return false
        return currentPassenger.pnr.isNotBlank() &&
               currentPassenger.lastName.isNotBlank()
    }

    // Validate if passenger details form is complete
    fun isPassengerDetailsComplete(): Boolean {
        val currentPassenger = passenger.value ?: return false
        return currentPassenger.passportNumber.isNotBlank()
    }
}
