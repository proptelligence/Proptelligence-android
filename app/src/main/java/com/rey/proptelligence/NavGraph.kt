package com.rey.proptelligence

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginLogic() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash"){
        composable("splash"){
            SplashScreen(navController = navController)
        }
        composable("login"){
            LoginScreen(navController = navController)
        }
        composable("otp"){
            OtpScreen(navController = navController)
        }
        composable("home"){
            HomeScreen(navController = navController)
        }
        composable("profile"){
            ProfileScreen(navController = navController)
        }
        composable("selectCity"){
            SelectCityScreen(navController = navController)
        }
    }
}