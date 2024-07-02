package com.proptelligencenet.proptelligence

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.SignIn.GoogleSignInLogic
import com.proptelligencenet.proptelligence.screens.AhmedabadProp
import com.proptelligencenet.proptelligence.screens.HyderabadProp

@Composable
fun LoginLogic(navController: NavHostController, googleSignInLogic: GoogleSignInLogic) {

    //val property = Property()

    NavHost(navController = navController, startDestination = "home"){
        composable("splash"){
            SplashScreen(navController = navController)
        }
        composable("login"){
            LoginScreen(navController = navController,googleSignInLogic = googleSignInLogic)
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
        composable("ahmedabad"){
            AhmedabadProp(navController = navController)
        }
        composable("mumbai"){
            MumbaiProp(navController = navController)
        }
        composable("bangalore"){
            BangaloreProp(navController = navController)
        }
        composable("kolkata"){
            KolkataProp(navController = navController)
        }
        composable("chennai"){
            ChennaiProp(navController = navController)
        }

        composable("products"){
            ProductsScreen(navController = navController)
        }
        composable("form"){
            FormScreen(navController = navController)
        }
        composable("blogs"){
            BlogsScreen(navController = navController)
        }
        composable("company"){
            CompanyScreen(navController = navController)
        }
    }
}