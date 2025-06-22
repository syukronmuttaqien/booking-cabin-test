package com.example.bookcabincodetest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookcabincodetest.model.PassengerModel

/**
 * Repository for handling passenger data operations
 */
class PassengerRepository {

    // In-memory cache of the passenger data
    private val _passengerData = MutableLiveData(PassengerModel())
    val passengerData: LiveData<PassengerModel> = _passengerData

    fun updatePassenger(passenger: PassengerModel) {
        _passengerData.value = passenger
    }

    fun updatePassengerField(update: (PassengerModel) -> PassengerModel) {
        _passengerData.value?.let { currentPassenger ->
            _passengerData.value = update(currentPassenger)
        }
    }

    // In a real app, this would connect to a backend service or local database
    fun checkInPassenger(onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Simulate API call success
        onSuccess()
    }

    companion object {
        // Singleton pattern
        @Volatile
        private var instance: PassengerRepository? = null

        fun getInstance(): PassengerRepository {
            return instance ?: synchronized(this) {
                instance ?: PassengerRepository().also { instance = it }
            }
        }
    }
}
