package com.proptelligencenet.proptelligence.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.proptelligencenet.proptelligence.ApiService.NetworkModule
import com.proptelligencenet.proptelligence.cart.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel: ViewModel(){
    // The cart is represented as a mutable state list of products
    val cart = mutableStateListOf<Product>()

    // Function to add a product to the cart
    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    fun clearCart() {
        cart.clear()
    }


    val qrCodeData = mutableStateOf<String?>(null)

    fun fetchQRCode(name: String, vpa: String, amount: String? = null) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val service = NetworkModule.getUPIQRService()
                val response = service.getQRCode(name, vpa, amount)
                qrCodeData.value = "https://upiqr.in/api/qr?name=$name&vpa=$vpa&format=png&amount=$amount" // Assuming the response contains the URL to the PNG image
            } catch (e: Exception) {
                println("Error fetching QR code: ${e.message}")
                qrCodeData.value = null
            }
        }
    }

}