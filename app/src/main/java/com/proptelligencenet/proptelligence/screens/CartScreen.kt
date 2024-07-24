package com.proptelligencenet.proptelligence.screens


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.caverock.androidsvg.SVG
import com.proptelligencenet.proptelligence.viewmodels.CartViewModel

@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {



    LaunchedEffect(key1 = Unit) {
        cartViewModel.fetchQRCode("Shreyas", "shreyassp002@oksbi", "200")
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cart Items",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(cartViewModel.cart) { product ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.name,
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove Item",
                        tint = Color.Red,
                        modifier = Modifier.size(24.dp)
                            .clickable { cartViewModel.removeFromCart(product) }
                    )
                }
            }
        }
        var amount = "500"

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://upiqr.in/api/qr?name=satyam&vpa=satyam2001anand@oksbi&format=png&amount=$amount")
                .crossfade(true)
                .build(),
            contentDescription = "Property Image",
            modifier = Modifier
                .size(200.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )


    }
}