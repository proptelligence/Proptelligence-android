package com.proptelligencenet.proptelligence.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.CustomDrawer
import com.proptelligencenet.proptelligence.CustomTopAppBar
import com.proptelligencenet.proptelligence.cart.Product
import com.proptelligencenet.proptelligence.viewmodels.CartViewModel

@Composable
fun LegalSubServicesScreen(navController: NavController, cartViewModel: CartViewModel){

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
                        Text(
                            text = "Add to Cart",
                            modifier = Modifier.padding(top = 40.dp),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Title Search or Legal Opinion",
                            modifier = Modifier.padding(top = 0.dp),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Agricultural Land",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .padding(end = 20.dp)
                                        .clickable {
                                            // When the add icon is clicked, add the product to the cart
                                            cartViewModel.addToCart(Product("Agricultural Land"))
                                        }
                                )

                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Converted Land",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    tint = Color.Black,
                                    modifier = Modifier.padding(end = 20.dp).clickable {
                                        cartViewModel.addToCart(Product("Converted Land"))
                                    }
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Commercial Properties",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    tint = Color.Black,
                                    modifier = Modifier.padding(end = 20.dp).clickable {
                                        cartViewModel.addToCart(Product("Commercial Properties"))
                                    }                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Project Land",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Project Land")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),


                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Flat like Apartment",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Flat like Apartment")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Individual House",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Individual House")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Sites/Plots/Villas",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Sites/Plots/Villas")) },
                                    tint = Color.Black
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Drafting",
                            modifier = Modifier.padding(top = 0.dp),
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Agreement Drafting",
                            modifier = Modifier.padding(top = 0.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Sales Agreement",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Sales Agreement")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),


                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Rent & Lease Agreement",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Rent & Lease Agreement")) },
                                    tint = Color.Black
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Deeds",
                            modifier = Modifier.padding(top = 0.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Sale",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Sale")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Gift",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Gift")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Release",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Release")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Rectification",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Rectification")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Will",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Will")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "GPA",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("GPA")) },
                                    tint = Color.Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "SPA",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("SPA")) },
                                    tint = Color.Black
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                                .height(55.dp)
                                .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
                                .background(Color.White),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = "Mortgage",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = "Add icon",
                                    modifier = Modifier.padding(end = 20.dp).clickable { cartViewModel.addToCart(Product("Mortgage")) },
                                    tint = Color.Black
                                )
                            }
                        }


                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LegalSubServicesScreenPreview() {
//    LegalSubServicesScreen(rememberNavController())
//}