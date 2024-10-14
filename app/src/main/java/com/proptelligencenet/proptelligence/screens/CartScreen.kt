package com.proptelligencenet.proptelligence.screens



import CartViewModel
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

import coil.request.ImageRequest
import com.cashfree.pg.api.CFPaymentGatewayService
import com.proptelligencenet.proptelligence.SignIn.UserData
import com.proptelligencenet.proptelligence.cart.Product
import com.proptelligencenet.proptelligence.ui.theme.Lightlightgray


@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val paymentStatus by cartViewModel.paymentStatus
    val isPaymentFormVisible by cartViewModel.isPaymentFormVisible // Observing payment form visibility
    val userData by cartViewModel.userData

    // Set CartViewModel as the payment callback
    LaunchedEffect(Unit) {
        try {
            CFPaymentGatewayService.getInstance().setCheckoutCallback(cartViewModel)
        } catch (e: Exception) {
            // Log or show an error if the callback setting fails
            Log.e("CartScreen", "Error setting checkout callback: ${e.message}")
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button and cart items
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
            }
        }

        Text(
            text = "Cart Items",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 0.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))

        // List of cart items
        Column {
            cartViewModel.cart.forEach { product ->
                CartItem(product, onRemove = { cartViewModel.removeFromCart(it) })
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        if (cartViewModel.cart.isNotEmpty()) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Total: ${cartViewModel.cart.sumOf { it.price }} ₹" ,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Toggle between the Pay Now button and the form
            if (!isPaymentFormVisible) {
                Button(
                    onClick = { cartViewModel.togglePaymentForm() },
                    colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#32357A")))
                ) {
                    Text(text = "Pay Now", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            } else {
                // Form for user details
                UserDetailForm(
                    userData = userData,
                    onFormSubmit = { updatedUserData ->
                        // Update the ViewModel's userData with the correct data
                        cartViewModel.userData.value = updatedUserData
                        // Now proceed to create the payment
                        cartViewModel.createPayment(context)
                    }
                )



            }

            Spacer(modifier = Modifier.height(20.dp))

            // Show payment status if available
            paymentStatus?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                cartViewModel.paymentStatus.value = null
                cartViewModel.clearCart()
            }
        } else {
            Text(
                text = "Your cart is empty.",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun CartItem(product: Product, onRemove: (Product) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${product.name} - ${product.price} ₹",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Remove Item",
                tint = Color.Red,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onRemove(product) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailForm(userData: UserData, onFormSubmit: (UserData) -> Unit) {
    // Keep track of form inputs
    val name = remember { mutableStateOf(userData.customer_name ?: "") }
    val email = remember { mutableStateOf(userData.customer_email ?: "") }
    val phone = remember { mutableStateOf(userData.customer_phone ?: "") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Enter Your Details",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Name Field
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Full Name", color = Color.Black) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Lightlightgray, // Set background color here
                unfocusedContainerColor = Lightlightgray,
                disabledContainerColor = Lightlightgray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .clip(RoundedCornerShape(8.dp)),
            singleLine = true
        )

        // Email Field
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email Address", color = Color.Black) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Lightlightgray, // Set background color here
                unfocusedContainerColor = Lightlightgray,
                disabledContainerColor = Lightlightgray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .clip(RoundedCornerShape(8.dp)),
            singleLine = true
        )

        // Phone Field
        TextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            label = { Text("Phone Number", color = Color.Black) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Lightlightgray, // Set background color here
                unfocusedContainerColor = Lightlightgray,
                disabledContainerColor = Lightlightgray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .clip(RoundedCornerShape(8.dp)),
            singleLine = true
        )

        // Submit Button
        Button(
            onClick = {
                onFormSubmit(
                    UserData(
                        customer_name = name.value,  // Name
                        customer_email = email.value, // Email
                        customer_phone = phone.value  // Phone
                    )
                )
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF3F51B5)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Proceed to Payment",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}







