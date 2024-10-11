package com.proptelligencenet.proptelligence.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.R

data class City(val name: String, val imageId: Int)

@Composable
fun SelectCityScreen(navController: NavController) {
    val cities = listOf(
        City("Delhi", R.drawable.delhi),
        City("Mumbai", R.drawable.mumbai),
        City("Bangalore", R.drawable.bangalore),
        City("Hyderabad", R.drawable.hyderabad),
        City("Ahmedabad", R.drawable.ahmedabad),
        City("Chennai", R.drawable.chennai),
        City("Kolkata", R.drawable.kolkata),
        City("Pune", R.drawable.pune),
        City("Gurugram", R.drawable.gurugram),
        City("Patna", R.drawable.patna)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#CBD5DD"))),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Discover your city",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(cities.chunked(2)) { rowCities ->
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (city in rowCities) {
                        // Use Card composable here
                        Card(
                            modifier = Modifier
                                .padding(20.dp)
                                .aspectRatio(1f)
                                .weight(1f)
                                .clickable { navController.navigate("login") },
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White), // Set background color
                            shape = RoundedCornerShape(12.dp) // You can use RoundedCornerShape for rounded corners
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(2.dp) // Add padding inside the card
                                    .fillMaxWidth()
                            ) {
                                Spacer(modifier = Modifier.height(7.dp))
                                Image(
                                    painter = painterResource(city.imageId),
                                    contentDescription = city.name,
                                    modifier = Modifier
                                        .size(90.dp) // Adjust image size as needed
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
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

@Preview(showBackground = true)
@Composable
fun SelectCityScreenPreview() {
    SelectCityScreen(rememberNavController())
}