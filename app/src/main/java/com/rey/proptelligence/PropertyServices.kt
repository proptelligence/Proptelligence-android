package com.rey.proptelligence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PropertyServicesScreen(navController: NavController){
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val cities = listOf(
        //City("Delhi", R.drawable.delhi),
        City("Mumbai", R.drawable.mumbai),
        City("Bangalore", R.drawable.bangalore),
        City("Hyderabad", R.drawable.hyderabad),
        //City("Ahmedabad", R.drawable.ahmedabad),
        City("Chennai", R.drawable.chennai_changed),
        City("Kolkata", R.drawable.kolkata),
        //City("Pune", R.drawable.pune_changed),
        // Add more cities...
    )

    CustomDrawer(
        navController = navController,
        drawerState = drawerState) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
            // rest of your code
        ) {
            innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().background(Color(android.graphics.Color.parseColor("#CBD5DD")))
                    .padding(top = 55.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "Choose the City :",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )


                LazyColumn {
                    items(cities.chunked(2)) { rowCities ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (city in rowCities) {
                                // Use Card composable here
                                Card(
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .aspectRatio(1f)
                                        .weight(1f)
                                        .clickable { navController.navigate(city.name) },
                                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White), // Set background color
                                    shape = RoundedCornerShape(12.dp) // You can use RoundedCornerShape for rounded corners
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .padding(0.dp) // Add padding inside the card
                                            .fillMaxWidth()
                                    ) {
                                        Image(
                                            painter = painterResource(city.imageId),
                                            contentDescription = city.name,
                                            modifier = Modifier
                                                .size(100.dp) // Adjust image size as needed
                                                .clip(CircleShape)
                                        )
                                        Text(
                                            text = city.name,
                                            color = Color.Black,
                                            modifier = Modifier.padding(top = 8.dp)
                                        )
                                    }
                                }
                            }
                            if (rowCities.size < 2) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyServicesScreenPreview(){
    PropertyServicesScreen(rememberNavController())
}