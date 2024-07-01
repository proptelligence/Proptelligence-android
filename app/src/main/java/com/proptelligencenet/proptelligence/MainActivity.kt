package com.proptelligencenet.proptelligence

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.proptelligencenet.proptelligence.SignIn.GoogleSignInLogic
import com.proptelligencenet.proptelligence.ui.theme.ProptelligenceTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val RC_SIGN_IN = 9001 // Add this line
    private lateinit var googleSignInLogic: GoogleSignInLogic // Add this line
    private lateinit var navController: NavController // Add this line

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProptelligenceTheme {
                navController = rememberNavController() // Initialize navController
                googleSignInLogic = GoogleSignInLogic(this, navController)

                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    innerPadding ->
                    LoginLogic(navController as NavHostController, googleSignInLogic)
                }
            }
        }
    }

    // Add this function
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                lifecycleScope.launch {
                    googleSignInLogic.firebaseAuthWithGoogle(account)
                }
            } catch (e: ApiException) {
                // Google Sign-In failed
            }
        }
    }
}

