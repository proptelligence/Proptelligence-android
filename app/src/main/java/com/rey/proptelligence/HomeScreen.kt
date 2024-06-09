package com.rey.proptelligence

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun HomeScreen(navController: NavController){
    val bgColor = Color(0xFFECFADC)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home Screen Aa gayi bhai", color = Color.Black)
        Button(
            onClick = {
                Firebase.auth.signOut()
                navController.navigate("login")
            }
        ) {
            Text(text = "Logout")
        }
    }
}