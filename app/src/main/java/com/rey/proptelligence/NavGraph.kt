package com.rey.proptelligence

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginLogic() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "services"){
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
        composable("editProfile"){
            EditProfileScreen(navController = navController)
        }
        composable("legalServices"){
            LegalServicesScreen(navController = navController)
        }
        composable("services"){
            ServicesScreen(navController = navController)
        }
        composable("propertyServices"){
            ServicesScreen(navController = navController)
        }
    }
}