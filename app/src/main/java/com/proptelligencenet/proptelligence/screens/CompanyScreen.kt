package com.proptelligencenet.proptelligence.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.CustomDrawer
import com.proptelligencenet.proptelligence.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

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
                LazyColumn( modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    item {
                        Text(text = "About Us",
                            modifier = Modifier
                                .padding(top = 50.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Text(text = "Proptelligence is an AI-powered real estate and legal platform that helps agents, attorneys, and other real estate professionals find and procure properties. In a nutshell, we create a seamless experience for agents and attorneys to find properties and make offers. Our solution also automates much of the legal process in real estate transactions by using AI to automate tasks such as document review, contract negotiation, and financial analysis. Proptelligence is a World Leading Data-Driven company using PropTech and Legal Tech. We provide smart solutions for companies of all sizes and pride ourselves on our unparalleled, dedicated service. At Proptelligence, we believe that the right understanding and technological edge can lead companies towards a successful future. Unlike other services, we don't charge for basic features like data update - it's always free for our clients. Proptelligence focuses on Data-Driven technology Solutions using Data Science, Cloud, and Digital Platforms. We are a technology company that is developing AI for the legal and real estate sectors.",
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify
                            )
                        }
                        Text(text = "Mission",
                            modifier = Modifier
                                .padding(top = 50.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Text(text = "At Proptelligence Technology, our mission is to revolutionize the real estate industry by leveraging cutting-edge technology and data-driven insights. We aim to empower real estate professionals and consumers alike with innovative solutions that enhance decision-making, streamline processes, and foster transparency. Our commitment is to deliver exceptional value, drive growth, and build lasting relationships with our clients and partners.",
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify
                            )
                        }
                        Text(text = "Vision",
                            modifier = Modifier
                                .padding(top = 50.dp),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Text(text = "Our vision is to be the leading provider of intelligent real estate technology solutions globally. We strive to set the standard for innovation, reliability, and excellence in the industry. By continuously evolving and adapting to the ever-changing landscape, we envision a future where our technology transforms the way people buy, sell, and manage properties, making real estate transactions more efficient, accessible, and enjoyable for everyone involved.",
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .width(300.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Add elevation
                            colors = CardDefaults.cardColors(containerColor = Color.White), // Set card color
                            onClick = { /* Handle card click */}
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Text(text = "Contact Us",
                                    modifier = Modifier
                                        .padding(top = 20.dp),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )



                                Column(
                                    modifier = Modifier
                                        .padding(16.dp) // Add padding within the card
                                ) {

                                    Text(text = "We Work, Roshini Tech Hub, Anand Nagar, Aswath Nagar, Chinnapanna Halli, Bengaluru, Karnataka 560037", color = Color.Black, fontWeight = FontWeight.Normal)
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(text = "connect@proptelligence.net", color = Color.Blue, fontWeight = FontWeight.Normal)

                                }


                            }
                        }

                        Spacer(modifier = Modifier.height(60.dp))


                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CompanyScreenPreview() {
    CompanyScreen(rememberNavController())
}