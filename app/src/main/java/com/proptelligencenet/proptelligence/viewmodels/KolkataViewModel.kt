package com.proptelligencenet.proptelligence.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proptelligencenet.proptelligence.ApiService.CitiesInfo
import com.proptelligencenet.proptelligence.ApiService.NetworkModule
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class KolkataViewModel: ViewModel() {
    private val _kolkataProperties = MutableStateFlow<CitiesInfo?>(null)
    val kolkataProperties = _kolkataProperties.asStateFlow()

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
                withTimeout(20000) { // Timeout duration in milliseconds
                    _kolkataProperties.value = NetworkModule.getPropertyService().getKolkataProperties()
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