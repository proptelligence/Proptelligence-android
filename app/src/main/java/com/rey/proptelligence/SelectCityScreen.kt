package com.rey.proptelligence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class City(val name: String, val imageId: Int)

@Composable
fun SelectCityScreen(navController: NavController) {
    val cities = listOf(
        City("Delhi", R.drawable.delhi),
        City("Mumbai", R.drawable.mumbai),
        City("Bangalore", R.drawable.bangalore),
        City("Hyderabad", R.drawable.hyderabad),
        City("Ahmedabad", R.drawable.ahmedabad),
        City("Chennai", R.drawable.chennai_changed),
        City("Kolkata", R.drawable.kolkata),
        City("Pune", R.drawable.pune_changed),
        // Add more cities...
    )

    Column(
        modifier = Modifier.fillMaxSize().background(Color(android.graphics.Color.parseColor("#CBD5DD"))),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Select Your City",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#32357A")),
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(cities.chunked(2)) { rowCities ->
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (city in rowCities) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(8.dp)
                                .aspectRatio(1f)
                                .border(0.5.dp, Color.Black, CircleShape)
                                .weight(1f)
                                .clip(CircleShape)
                                .background(Color.White)
                                .clickable { navController.navigate("login") }
                        ) {
                            Image(
                                painter = painterResource(city.imageId),
                                contentDescription = city.name,
                                modifier = Modifier
                                    .size(130.dp)


                            )
                            Text(text = city.name, color = Color.Black)
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