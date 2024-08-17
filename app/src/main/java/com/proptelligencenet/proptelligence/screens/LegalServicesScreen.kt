package com.proptelligencenet.proptelligence.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
import com.proptelligencenet.proptelligence.cart.Product
import com.proptelligencenet.proptelligence.viewmodels.CartViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LegalServicesScreen(navController: NavController, cartViewModel: CartViewModel) {
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
        ){
                innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ){
                LazyColumn( modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    item {
                        Text(
                            text = "Legal Services",
                            modifier = Modifier.padding(top = 50.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = "Welcome to Proptelligence Legal Services, your trusted destination for comprehensive legal solutions. From intricate business contracts to personal legal matters, our team of seasoned attorneys is here to navigate the complex terrain of law on yourbehalf.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black,
                            //maxLines = 3, // Limit the text to a maximum of 3 lines
                            overflow = TextOverflow.Clip // Add ellipsis (...) to indicate truncated text
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(android.graphics.Color.parseColor("#277ca2")),
                                        Color(android.graphics.Color.parseColor("#FFFFFF"))
                                    )
                                )
                            )
                            .clip(RoundedCornerShape(10.dp))
                            .border(0.dp, Color.Black, shape = RoundedCornerShape(10.dp)),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier
                                .width(150.dp)
                                .padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830080/proptelligence/fbabrbvxhwdjmuhm9kw7.png")
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Advocates Consultation Image",
                                    modifier = Modifier
                                        .size(170.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .align(Alignment.CenterHorizontally),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(modifier = Modifier
                                .padding(10.dp),
                            ) {
                                Text(text = "Advocates",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(text = "Consultation",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(text = "•Your tailored legal partner",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•Offering litigation support",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•Advisory services",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•Contract drafting",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•Corporate law",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•Real estate transactions",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                                Text(text = "•IP protection",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )

                                Button(onClick = {cartViewModel.addToCart(Product("Advocate Consultation", 500))},
                                    modifier = Modifier.padding(10.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#32357A")))
                                ) {
                                    Text(text = "Book Now", color = Color.White)

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(25.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()

                        ) {
                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .weight(1f)
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),

                                onClick = {navController.navigate("emailUs")}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830078/proptelligence/vairh2sgdnx0hh9gurrh.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "Title Search OR Legal Opinion Image",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(140.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(text = "Title Search OR Legal", color = Color.Black)
                                    Text(text = "Opinion", color = Color.Black)
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .weight(1f)
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                onClick = {navController.navigate("emailUs")}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830095/proptelligence/dzxjzqfdnvkzoffwdxfo.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(140.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(text = "Drafting", color = Color.Black)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .weight(1f)
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                onClick = {cartViewModel.addToCart(Product("Affidavits", 2399))}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830095/proptelligence/gepp4kfetas9zr7ud1jg.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(140.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(text = "Affidavits", color = Color.Black)
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .weight(1f)
                                    .padding(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                onClick = {cartViewModel.addToCart(Product("Registration Support at SRO", 4999))}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://res.cloudinary.com/duot2ognl/image/upload/v1719830093/proptelligence/gc9vf2ovct9uffn7f6kl.png")
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(140.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .align(Alignment.CenterHorizontally),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(text = "Registration Support", color = Color.Black)
                                    Text(text = "at SRO", color = Color.Black)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(100.dp))

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
        }
    }


}


//@Preview(showBackground = true)
//@Composable
//fun LegalServicesScreenPreview() {
//
//    LegalServicesScreen(rememberNavController())
//}