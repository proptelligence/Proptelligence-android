package com.rey.proptelligence.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rey.proptelligence.ApiService.CitiesInfo
import com.rey.proptelligence.ApiService.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HyderabadViewModel : ViewModel() {
    private val _hyderabadProperties = MutableStateFlow<CitiesInfo?>(null)
    val hyderabadProperties = _hyderabadProperties.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _hyderabadProperties.value = NetworkModule.getPropertyService().getHyderabadProperties()
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching data: ${e.message}" // Update an error state
            }
        }
    }
}