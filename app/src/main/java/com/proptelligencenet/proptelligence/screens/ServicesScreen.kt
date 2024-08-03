package com.proptelligencenet.proptelligence.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.proptelligencenet.proptelligence.CustomDrawer
import com.proptelligencenet.proptelligence.CustomTopAppBar
import com.proptelligencenet.proptelligence.R


@Composable
fun ServicesScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val context = LocalContext.current
    val rememberedContext = remember { context }


    CustomDrawer(
        navController = navController,
        drawerState = drawerState) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
            // rest of your code
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                                .padding(
                                    top = 10.dp,
                                    start = 16.dp,
                                    end = 16.dp
                                ), // Add padding around cards
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
                                    .clickable { navController.navigate("propertyServices") },
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
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830096/proptelligence/yf0xrbvvlfie7ggnetym.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "Property Image",
                                        modifier = Modifier
                                            .size(150.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
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
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830080/proptelligence/fbabrbvxhwdjmuhm9kw7.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "Legal Services Image",
                                        modifier = Modifier
                                            .size(150.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
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

                        Spacer(modifier = Modifier.height(180.dp))

                        Column(
                            modifier = Modifier
                                .background(color = Color(android.graphics.Color.parseColor("#32357A"))),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(
                                            text = "Company",
                                            fontSize = 17.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )

                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "Home",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier.clickable {
                                                navController.navigate("home")
                                            }
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "About Us",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier.clickable {
                                                navController.navigate("company")
                                            }
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "Services",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier.clickable {
                                                navController.navigate("services")
                                            }
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "Solutions",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier.clickable {
                                                navController.navigate("services")
                                            }
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "Contact Us",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier.clickable {
                                                navController.navigate("company")
                                            }
                                        )
                                    }
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.weight(1f)
                                    ) {

                                        Text(
                                            text = "Our Presence",
                                            fontSize = 17.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            text = "We Work, Roshini Tech Hub, Anand Nagar, Aswath Nagar, Chinnapanna Halli, Bengaluru, Karnataka 560037",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White
                                        )
                                    }
                                }



                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "Follow Us",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(20.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_facebook), // Use your Facebook image file
                                        contentDescription = "facebook icon",
                                        modifier = Modifier
                                            .size(30.dp) // Set the size of the image
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data =
                                                        Uri.parse("https://www.facebook.com/proptelligence")
                                                }
                                                rememberedContext.startActivity(intent)
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_instagram), // Use your Facebook image file
                                        contentDescription = "instagram icon",
                                        modifier = Modifier
                                            .size(30.dp) // Set the size of the image
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data =
                                                        Uri.parse("https://www.instagram.com/proptelligence")
                                                }
                                                rememberedContext.startActivity(intent)
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_youtube),contentDescription = "youtube icon",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data =
                                                        Uri.parse("https://www.youtube.com/proptelligence/")
                                                }
                                                rememberedContext.startActivity(intent)
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_linkedin), // Use your Facebook image file
                                        contentDescription = "linkedin icon",
                                        modifier = Modifier
                                            .size(30.dp) // Set the size of the image
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data =
                                                        Uri.parse("https://www.linkedin.com/company/proptelligence/")
                                                }
                                                rememberedContext.startActivity(intent)
                                            }
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Legal",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(
                                            text = "Privacy Policy",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier

                                                .clickable {
                                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                                        data =
                                                            Uri.parse("https://www.proptelligence.net/privacypolicy")
                                                    }
                                                    rememberedContext.startActivity(intent)
                                                }
                                        )
                                        Spacer(modifier = Modifier.width(15.dp))
                                        Text(
                                            text = "Terms & Conditions",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color.White,
                                            modifier = Modifier
                                                .clickable {
                                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                                        data =
                                                            Uri.parse("https://www.proptelligence.net/proptelligence-terms&conditions")
                                                    }
                                                    rememberedContext.startActivity(intent)
                                                }
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Refund & Cancellation Policy",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.White,
                                        modifier = Modifier
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data =
                                                        Uri.parse("https://www.proptelligence.net/proptelligence-refund-policy")
                                                }
                                                rememberedContext.startActivity(intent)
                                            }
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))


                                Text(
                                    text = "© 2024 Proptelligence. All rights reserved.",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }
            }
        } }
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    ServicesScreen(navController = rememberNavController())
}