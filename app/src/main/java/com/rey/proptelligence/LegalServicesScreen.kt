package com.rey.proptelligence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
fun LegalServicesScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

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
                        Text(text = "Legal Services",
                            modifier = Modifier
                                .padding(top = 50.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(text = "Welcome to Proptelligence Legal Services, your trusted",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                        Text(text = "destination for comprehensive legal solutions. From",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )

                        Text(text = "intricate business contracts to personal legal matters,",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                        Text(text = "our team of seasoned attorneys is here to navigate the",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )

                        Text(text = "complex terrain of law on your behalf.",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
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
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp)),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier
                                .width(150.dp)
                                .padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                Image(painter = painterResource(id = R.drawable.advocates_consultation), contentDescription = "Advocates Consultation",
                                    modifier = Modifier
                                        .size(170.dp)
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

                                Button(onClick = {},
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
                                    .weight(1f)
                                    .padding(8.dp)
                                ,

                                onClick = {}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.title_opinion),
                                        contentDescription = "Image Description",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                    Text(text = "Title Search OR Legal", color = Color.Black)
                                    Text(text = "Opinion", color = Color.Black)
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp),
                                onClick = {}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.drafting_legal),
                                        contentDescription = "Image Description"
                                    )
                                    Text(text = "Drafting", color = Color.Black)
                                }
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp),
                                onClick = {}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.affidavits_legal),
                                        contentDescription = "Image Description"
                                    )
                                    Text(text = "Affidavits", color = Color.Black)
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp),
                                onClick = {}

                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.legal_services),
                                        contentDescription = "Image Description"
                                    )
                                    Text(text = "Registration Support", color = Color.Black)
                                    Text(text = "at SRO", color = Color.Black)
                                }
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
fun LegalServicesScreenPreview() {

    LegalServicesScreen(rememberNavController())
}