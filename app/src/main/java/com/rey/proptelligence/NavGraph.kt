package com.rey.proptelligence

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rey.proptelligence.screens.HyderabadProp

@Composable
fun LoginLogic() {
    val navController = rememberNavController()
    //val property = Property()

    NavHost(navController = navController, startDestination = "hyderabad"){
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
            PropertyServicesScreen(navController = navController)
        }
        /*composable("delhi"){
            DelhiProp(navController = navController, property = property)
        }*/
        composable("hyderabad"){
            HyderabadProp(navController = navController)
        }
        composable("products"){
            ProductsScreen(navController = navController)
        }
        composable("form"){
            FormScreen(navController = navController)
        }
    }
}