package com.rey.proptelligence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController




@Composable
fun ServicesScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)




    CustomDrawer(
        navController = navController,
        drawerState = drawerState) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
            // rest of your code
        ) {innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 50.dp, start = 16.dp, end = 16.dp), // Add padding around cards
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Services",
                    modifier = Modifier.padding(top = 30.dp), // Add space below title
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(60.dp))

                // Property Services Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .clickable { navController.navigate("propertyServices")},
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.property_services), // Replace with your image
                            contentDescription = "Property Services",
                            modifier = Modifier.size(150.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Add space between image and text
                        Text(
                            text = "Property Services",
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Legal Services Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("legalServices") },
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.advocates_consultation    ), // Replace with your image
                            contentDescription = "Legal Services",
                            modifier = Modifier.size(150.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Add space between image and text
                        Text(
                            text = "Legal Services",
                            fontSize = 22.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    ServicesScreen(navController = rememberNavController())
}