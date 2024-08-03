package com.proptelligencenet.proptelligence.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val context = LocalContext.current
    val rememberedContext = remember { context } // Store context using remember



    CustomDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
            // rest of your code
        ) {
            innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6"))),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    contentPadding = PaddingValues(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth() // Make box fill width
                                .height(280.dp), // Set the height of the box
                            contentAlignment = Alignment.Center // Align the content in the center of the box
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.home_background),
                                contentDescription = "Home background",
                                modifier = Modifier
                                    .fillMaxSize(), // Make image fill the box
                                contentScale = ContentScale.Crop
                            )
                            Surface(
                                color = Color.Black.copy(alpha = 0.4f), // Semi-transparent black color
                                modifier = Modifier
                                    .fillMaxSize() // Make surface fill the box
                            ) {
                                // Add your content here
                                Column(
                                    modifier = Modifier
                                        .padding(top = 0.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {
                                    Spacer(modifier = Modifier.height(60.dp))
                                    Text(
                                        text = "Unlock Our Free Property",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                    )
                                    Text(
                                        text = "Service",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                    )

                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "Experience effortless property management with",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "Proptelligence. With our free services, managing",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "your properties has never been easier.",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )

                                }
                            }


                        }
                        Spacer(modifier = Modifier.height(60.dp))
                        Text(
                            text = "Explore Services",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Row {
                            Card(
                                modifier = Modifier
                                    .size(170.dp)
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { navController.navigate("legalServices") },
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                            ) {
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.service_legal),
                                        contentDescription = "Legal Services Image",
                                        modifier = Modifier
                                            .height(100.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(
                                        text = "Legal Services",
                                        modifier = Modifier.padding(8.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.Black
                                    )
                                }
                            }
                            
                            Spacer(modifier = Modifier.width(5.dp))

                            Card(
                                modifier = Modifier
                                    .size(170.dp)
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { navController.navigate("propertyServices") },
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                            ) {
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.service_property),
                                        contentDescription = "Property Services Image",
                                        modifier = Modifier
                                            .height(100.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(
                                        text = "Property Services",
                                        modifier = Modifier.padding(8.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.Black
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(80.dp))
                        ContentView()
                        Spacer(modifier = Modifier.height(100.dp))


                        Box(
                            modifier = Modifier
                                .fillMaxWidth() // Make box fill width
                                .height(300.dp), // Set the height of the box
                            contentAlignment = Alignment.Center // Align the content in the center of the box
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.get_background),
                                contentDescription = "Get background",
                                modifier = Modifier
                                    .fillMaxSize(), // Make image fill the box
                                contentScale = ContentScale.Crop
                            )
                            Surface(
                                color = Color.Black.copy(alpha = 0.3f), // Semi-transparent black color
                                modifier = Modifier
                                    .fillMaxSize() // Make surface fill the box
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = "Get Free Real Estate Guidance",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "& Secure Legal Support",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "Get expert guidance throughout your real estate journey, with a FREE consultation and access to our optional legal support. Don't let legal worries slow you down. Proptelligence empowers you with the resources and expertise you need to make informed decisions and navigate the real estate market with confidence.",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            text = "Blogs",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .width(300.dp)
                                .clip(RoundedCornerShape(8.dp)),
                                //.border(0.5.dp, Color.Gray, shape = RoundedCornerShape(8.dp)), // Make card fill width
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), // Add elevation
                            shape = RoundedCornerShape(8.dp), // Add rounded corners
                            colors = CardDefaults.cardColors(containerColor = Color.White), // Set card color
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data =
                                        Uri.parse("https://www.proptelligence.net/blogdetails")
                                }
                                rememberedContext.startActivity(intent)
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(0.dp) // Add padding within the card
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.blog),
                                    contentDescription = "Blogs Image",
                                    modifier = Modifier

                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(8.dp))
                                        .align(Alignment.CenterHorizontally),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    modifier = Modifier
                                        .padding(16.dp) // Add padding within the card
                                ) {

                                    Text(text = "Our blogs cover a wide array of topics, from industry trends and market analysis to practical tips and expert advice....", color = Color.Black, fontWeight = FontWeight.Normal)

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

data class BannerItem(
    val imageResourceId: String,
    val text: String,
    val subtext: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentView() {
    val list = listOf(
        BannerItem("https://res.cloudinary.com/duot2ognl/image/upload/v1719830096/proptelligence/yf0xrbvvlfie7ggnetym.png", "Property Services", "At Proptelligence, we recognize the challenges faced by property owners and strive to provide innovative solutions tailored to their needs."),
        BannerItem("https://res.cloudinary.com/duot2ognl/image/upload/v1719830093/proptelligence/gc9vf2ovct9uffn7f6kl.png", "Legal Services", "Navigating the legal complexities of real estate transactions can be daunting."),
        BannerItem("https://res.cloudinary.com/duot2ognl/image/upload/v1719830080/proptelligence/fbabrbvxhwdjmuhm9kw7.png", "Advocates Consultation", "Expert legal guidance tailored to your needs. Advocating for your rights and providing strategic counsel"),
        BannerItem("https://res.cloudinary.com/duot2ognl/image/upload/v1719830085/proptelligence/sqgmbx7mjgxjsfecu1xl.png", "Title Search OR Legal Opinion", "A Property Title Opinion is a legal document that offers an assessment regarding the legal standing of a specific real estate property."),
        BannerItem("https://res.cloudinary.com/duot2ognl/image/upload/v1719830090/proptelligence/p5s9gublftpiy5jtakut.png", "Agreement Drafting", "Our team creates clear and concise agreements tailored to your specific requirements.")
    )

    val pagerState = rememberPagerState(pageCount = { list.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            HorizontalPager(
                modifier = Modifier.height(400.dp),
                beyondBoundsPageCount = Int.MAX_VALUE,
                pageSpacing = 15.dp,
                contentPadding = PaddingValues(horizontal = 40.dp),
                state = pagerState
            ) { page ->
                list.getOrNull(page % (list.size))?.let { content ->
                    BannerItemView(bannerItem = content)
                }
            }
        }
    }

    // Animate scroll to next page every 3 seconds
    LaunchedEffect(key1 = pagerState.currentPage) {
        delay(2000L)
        val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
        pagerState.animateScrollToPage(nextPage)
    }
}

@Composable
private fun BannerItemView(bannerItem: BannerItem) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(360.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(bannerItem.imageResourceId)
                    .crossfade(true)
                    .build(),
                contentDescription = "Service Images",
                modifier = Modifier
                    .size(230.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text(
                text = bannerItem.text,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = bannerItem.subtext,
                color = Color.Black,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
