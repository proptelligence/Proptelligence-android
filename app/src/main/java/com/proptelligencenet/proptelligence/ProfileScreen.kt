package com.proptelligencenet.proptelligence


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(200.dp)
//                .background(color = Color(android.graphics.Color.parseColor("#32357A")))
        ) {
            val (topImg, profile, title, back, pen) = createRefs()




            Image(painterResource(id = R.drawable.spongebob), null,
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                text = "Profile",
                fontSize = 30.sp,
                color = Color(android.graphics.Color.parseColor("#32357A")),
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            IconButton(onClick = { navController.navigate("home") },
                modifier = Modifier.constrainAs(back) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start, margin = (-120).dp)
                },

            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
            }
        }
        Text(text = "Shreyas Patil"
            , fontSize = 26.sp
            , fontWeight = FontWeight.Bold
            , color = Color(android.graphics.Color.parseColor("#32357A"))
            , modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = "shreyassp002@gmail.com"
            , fontSize = 18.sp
            , color = Color(android.graphics.Color.parseColor("#747679"))
        )
        Text(text = "+91 1234567890"
            , fontSize = 18.sp
            , color = Color(android.graphics.Color.parseColor("#747679"))
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White)
            .clickable { navController.navigate("editProfile")},// Set the background color

            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(5.dp),
                verticalArrangement = Arrangement.Center
                ) {
                Image(painterResource(id = R.drawable.write), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                        .size(45.dp)
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Edit Profile",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)

                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_2), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_3), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_4), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_5), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_6), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_6), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_6), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp)) // Add this line to make the corners rounded
            .background(Color.White), // Set the background color
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .fillMaxHeight().padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = R.drawable.btn_6), null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { }
                )
            }
            Column(modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
            ) {
                Text(text = "Notification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.arrow), null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { }
                )
            }
        }




    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}