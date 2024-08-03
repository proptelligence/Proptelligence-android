package com.proptelligencenet.proptelligence.screens

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.proptelligencenet.proptelligence.R
import com.proptelligencenet.proptelligence.SignIn.GoogleSignInLogic
import com.proptelligencenet.proptelligence.onLoginClicked

@Composable
fun LoginScreen(navController: NavController, googleSignInLogic: GoogleSignInLogic) {
    val context = LocalContext.current
    var phoneNum by remember { mutableStateOf("") }
    val bgColor = Color(0xFFF6F6F6)
    val enterNumberColor = Color(0xFF545151)

    val RC_SIGN_IN = 9001





    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(bgColor)
        .pointerInput(Unit) {
            detectTapGestures(onTap = { _ ->
                keyboardController?.hide()
            })
        }
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp)) {
            Text(text = "Login",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Icon(

                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Google Icon",
                tint = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        Spacer(modifier = Modifier.height(85.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {



            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Enter your mobile number",
                color = Color(android.graphics.Color.parseColor("#32357A")),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                value = phoneNum,
                onValueChange = {
                    if (it.length <= 10) phoneNum = it
                },
                label = { Text("Enter number", color = enterNumberColor) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color(android.graphics.Color.parseColor("#32357A")),
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .height(55.dp)
                    .width(350.dp)
                    .padding(start = 20.dp, end = 20.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(
                    color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Button(
                onClick = {
                    onLoginClicked(context, navController, phoneNum) {
                        Log.d("phoneBook", "Sending OTP")
                        navController.navigate("otp")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    if (phoneNum.length == 10) Color(android.graphics.Color.parseColor("#32357A")) else Color(android.graphics.Color.parseColor("#7E97AB"))
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(45.dp)
                    .width(350.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(12.dp))

            ) {
                Text(text = "Send OTP", color = Color.White)
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = " Or Login with ",
                color = Color.Black,
                fontSize = 12.sp
            )


            Spacer(modifier = Modifier.height(30.dp))
//            Row(
//                //modifier = Modifier.padding(16.dp), // Adjust the padding as needed
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_google), // Use your Google image file
//                    contentDescription = "Google Sign In",
//                    modifier = Modifier
//                        .size(40.dp) // Set the size of the image
//                        .clickable { /* Handle Google sign in here */
//                            googleSignInLogic.googleSignInClient.signOut()
//                            val signInIntent = googleSignInLogic.googleSignInClient.signInIntent
//                            (context as Activity).startActivityForResult(signInIntent, RC_SIGN_IN)
//                        }
//                )
//
//                Spacer(modifier = Modifier.width(40.dp))
//
//                Image(
//                    painter = painterResource(id = R.drawable.ic_facebook), // Use your Facebook image file
//                    contentDescription = "Facebook Sign In",
//                    modifier = Modifier
//                        .size(40.dp) // Set the size of the image
//                        .clickable { /* Handle Facebook sign in here */ }
//                )
//            }

            Image(
                painter = painterResource(id = R.drawable.ic_google), // Use your Google image file
                contentDescription = "Google Sign In",
                modifier = Modifier
                    .size(40.dp) // Set the size of the image
                    .clickable { /* Handle Google sign in here */
                        googleSignInLogic.googleSignInClient.signOut()
                        val signInIntent = googleSignInLogic.googleSignInClient.signInIntent
                        (context as Activity).startActivityForResult(signInIntent, RC_SIGN_IN)
                    }
            )


        }
    }
}