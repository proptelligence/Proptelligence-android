package com.rey.proptelligence.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rey.proptelligence.ApiService.CitiesInfo
import com.rey.proptelligence.ApiService.NetworkModule
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class ChennaiViewModel: ViewModel(){
    private val _chennaiProperties = MutableStateFlow<CitiesInfo?>(null)
    val chennaiProperties = _chennaiProperties.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    private val _timeoutOccurred = MutableStateFlow(false)
    val timeoutOccurred = _timeoutOccurred.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()


    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch {

            try {
                withTimeout(10000) { // Timeout duration in milliseconds
                    _chennaiProperties.value = NetworkModule.getPropertyService().getChennaiProperties()
                }
                _errorMessage.value = ""
                _timeoutOccurred.value = false
            } catch (e: TimeoutCancellationException) {
                _errorMessage.value = "Data fetch timed out. Tap to retry."
                _timeoutOccurred.value = true
            } catch (e: Exception) {
                _errorMessage.value = "No Internet Connection"
                _timeoutOccurred.value = true
            }
        }
    }
}