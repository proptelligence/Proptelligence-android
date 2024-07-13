package com.proptelligencenet.proptelligence.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.proptelligencenet.proptelligence.cart.Product

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
}