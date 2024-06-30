package com.rey.proptelligence.screens

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rey.proptelligence.ApiService.CitiesInfoItem
import com.rey.proptelligence.CustomDrawer
import com.rey.proptelligence.CustomTopAppBar
import com.rey.proptelligence.viewmodels.HyderabadViewModel

@Composable
fun HyderabadProp(navController: NavController) {
    val viewModel: HyderabadViewModel = viewModel()
    val hyderabadProperties by viewModel.hyderabadProperties.collectAsState()

    val timeoutOccurred by viewModel.timeoutOccurred.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()




    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val lifecycleOwner = LocalLifecycleOwner.current

    // Observe lifecycle events to refresh data when screen resumes
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && !timeoutOccurred) {
                viewModel.refreshData()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    CustomDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Display error message with refresh option
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                viewModel.refreshData()
                            }
                    )
                }

                // Show loading indicator or list of properties
                if (hyderabadProperties == null && !timeoutOccurred) {
                    //Text(text = "Loading properties...", color = Color.Black)
                    CircularProgressAnimated()

                } else {
                    LazyColumn {
                        items(hyderabadProperties ?: listOf()) { property ->
                            PropertyItem(property)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PropertyItem(property: CitiesInfoItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(0.5.dp, Color.Gray, shape = RoundedCornerShape(8.dp)), // Make card fill width
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Add elevation
        shape = RoundedCornerShape(8.dp), // Add rounded corners
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set card color
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Add padding within the card
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(property.propertyPhoto)
                    .crossfade(true)
                    .build(),
                contentDescription = "Property Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Text(text = "${property.propertyName}", color = Color.Black, fontWeight = FontWeight.SemiBold)
            Text(text = "${property.description}", color = Color.Black)


            Row {
                Text(text = "Price: ", color = Color.Red, fontWeight = FontWeight.SemiBold)
                Text(text = "${property.Price}", color = Color.Red)
            }

            Row {
                Text(text = "Location: ", color = Color.Black, fontWeight = FontWeight.SemiBold)
                Text(text = "${property.Locality}", color = Color.Black)
            }
        }
    }
}

@Composable
private fun CircularProgressAnimated(){
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)),
        label = "Loading.. "
    )

    CircularProgressIndicator(progress = progressAnimationValue)
}

@Preview(showBackground = true)
@Composable
fun HyderabadPropPreview() {
    HyderabadProp(rememberNavController())
}
