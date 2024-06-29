package com.rey.proptelligence.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import com.rey.proptelligence.ApiService.CitiesInfoItem
import com.rey.proptelligence.viewmodels.HyderabadViewModel


@Composable
fun HyderabadProp(navController: NavController) {
    val viewModel: HyderabadViewModel = viewModel()
    val hyderabadProperties by viewModel.hyderabadProperties.collectAsState()

    val errorMessage by viewModel.errorMessage.collectAsState()
    if (errorMessage.isNotEmpty()) {
        Text(text = errorMessage, color = Color.Red) // Display error message
    }

    // Observe lifecycle events to refresh data when screen resumes
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {

                // Refresh data (if needed)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // Loading state
    if (hyderabadProperties == null) {
        Text(text = "Loading data...")
    } else {
        // Data loaded successfully
        LazyColumn {
            items(hyderabadProperties!!) { property ->
                PropertyItem(property)
            }
        }
    }
}

@Composable
fun PropertyItem(property: CitiesInfoItem) {
    Column {

        Text(text = "Property Name: ${property.propertyName}")
        Text(text = "City: ${property.City}")
        Text(text = "Description: ${property.description}")
        Text(text = "Locality: ${property.Locality}")
        Text(text = "Price: ${property.Price}")
    }
}

@Preview(showBackground = true)
@Composable
fun HyderabadPropPreview() {
    HyderabadProp(rememberNavController())
}