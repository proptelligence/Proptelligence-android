package com.proptelligencenet.proptelligence.screens



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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

import coil.request.ImageRequest
import com.cashfree.pg.api.CFPaymentGatewayService

import com.proptelligencenet.proptelligence.viewmodels.CartViewModel

@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current  // Access the current context
    val paymentStatus by cartViewModel.paymentStatus  // Observe the payment status

    // Set CartViewModel as the payment callback
    LaunchedEffect(key1 = Unit) {
        CFPaymentGatewayService.getInstance().setCheckoutCallback(cartViewModel)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        Column {
            cartViewModel.cart.forEach { product ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp) // Add padding within the card
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
                                .clickable { cartViewModel.removeFromCart(product) }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        if (cartViewModel.cart.isNotEmpty()) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Total: ${cartViewModel.cart.sumBy { it.price }} ₹",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Payment Button
            Button(
                onClick = { cartViewModel.createPayment(context) },  // Pass the context here
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#32357A")))
            ) {
                Text(text = "Pay Now", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Show payment status if available
            paymentStatus?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                cartViewModel.paymentStatus.value = null
                cartViewModel.cart.clear()
            }



        } else {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Total: ${cartViewModel.cart.sumBy { it.price }} ₹",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))




    }
}
