package com.proptelligencenet.proptelligence

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val myColor = Color(0xFF017F67)
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var selectedItemIndex by remember { mutableStateOf(0) }

    CustomDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
            // rest of your code
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 65.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "Unlock Our Free Property",
                            modifier = Modifier.padding(top = 100.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Service",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.home_screen),
                            contentDescription = "City",
                            modifier = Modifier.size(230.dp)
                        )
                        Text(
                            text = "Experience effortless property management with",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Text(
                            text = "Proptelligence. With our free services, managing",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Text(
                            text = "your properties has never been easier.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            text = "Service",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        ContentView()
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            text = "Get Free Real Estate Guidance & Secure Legal Support",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Get expert guidance throughout your real estate journey, with a FREE consultation and access to our optional legal support. Don't let legal worries slow you down. Proptelligence empowers you with the resources and expertise you need to make informed decisions and navigate the real estate market with confidence.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            text = "Blogs",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(500.dp))
                    }
                }
            }
        }
    }
}

data class BannerItem(
    val imageResourceId: Int,
    val text: String,
    val subtext: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ContentView() {
    val list = listOf(
        BannerItem(R.drawable.property_services, "Property Services", "At Proptelligence, we recognize the challenges faced by property owners and strive to provide innovative solutions tailored to their needs."),
        BannerItem(R.drawable.legal_services, "Legal Services", "Navigating the legal complexities of real estate transactions can be daunting."),
        BannerItem(R.drawable.advocates_consultation, "Advocates Consultation", "Expert legal guidance tailored to your needs. Advocating for your rights and providing strategic counsel"),
        BannerItem(R.drawable.title_search, "Title Search OR Legal Opinion", "A Property Title Opinion is a legal document that offers an assessment regarding the legal standing of a specific real estate property."),
        BannerItem(R.drawable.agreement_drafting, "Agreement Drafting", "Our team creates clear and concise agreements tailored to your specific requirements.")
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

    LaunchedEffect(key1 = Unit) {
        pagerState.scrollToPage(list.size - 1)
    }
}

@Composable
private fun BannerItemView(bannerItem: BannerItem) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(360.dp)
            .background(Color.White)
            .border(1.dp, Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = bannerItem.imageResourceId),
                contentDescription = "Banner Image",
                modifier = Modifier.size(200.dp)
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
