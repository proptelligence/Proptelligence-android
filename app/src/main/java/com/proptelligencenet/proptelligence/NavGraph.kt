package com.proptelligencenet.proptelligence

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proptelligencenet.proptelligence.screens.BangaloreProp
import com.proptelligencenet.proptelligence.screens.ChennaiProp
import com.proptelligencenet.proptelligence.screens.CompanyScreen
import com.proptelligencenet.proptelligence.screens.EditProfileScreen
import com.proptelligencenet.proptelligence.screens.FormScreen
import com.proptelligencenet.proptelligence.screens.HomeScreen
import com.proptelligencenet.proptelligence.screens.KolkataProp
import com.proptelligencenet.proptelligence.screens.LegalServicesScreen
import com.proptelligencenet.proptelligence.screens.LegalSubServicesScreen
import com.proptelligencenet.proptelligence.screens.LoginScreen
import com.proptelligencenet.proptelligence.screens.MumbaiProp
import com.proptelligencenet.proptelligence.screens.OtpScreen
import com.proptelligencenet.proptelligence.screens.ProductsScreen
import com.proptelligencenet.proptelligence.screens.ProfileScreen
import com.proptelligencenet.proptelligence.screens.PropertyServicesScreen
import com.proptelligencenet.proptelligence.screens.SelectCityScreen
import com.proptelligencenet.proptelligence.screens.ServicesScreen
import com.proptelligencenet.proptelligence.screens.SplashScreen
import com.proptelligencenet.proptelligence.SignIn.GoogleSignInLogic
import com.proptelligencenet.proptelligence.screens.AhmedabadProp
import com.proptelligencenet.proptelligence.screens.CartScreen
import com.proptelligencenet.proptelligence.screens.EmailUs
import com.proptelligencenet.proptelligence.screens.HyderabadProp
import com.proptelligencenet.proptelligence.viewmodels.CartViewModel

@Composable
fun LoginLogic(navController: NavHostController, googleSignInLogic: GoogleSignInLogic) {

    //val property = Property()
    val cartViewModel: CartViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
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
            LegalServicesScreen(navController = navController, cartViewModel = cartViewModel)
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

        composable("company"){
            CompanyScreen(navController = navController)
        }

        composable("legalSubServices"){
            LegalSubServicesScreen(navController = navController, cartViewModel = cartViewModel)
        }

        composable("cart"){
            CartScreen(navController = navController, cartViewModel = cartViewModel)
        }
        composable("emailUs"){
            EmailUs(navController = navController)
        }

    }
}