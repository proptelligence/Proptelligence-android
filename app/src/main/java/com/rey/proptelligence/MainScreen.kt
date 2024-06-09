package com.rey.proptelligence

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider

@Composable
fun MainScreen(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            LoginScreen(navController = navController)
        }
        composable("otp"){
            OtpScreen(navController = navController)
        }
        composable("home"){
            HomeScreen(navController = navController)
        }
    }
}

val auth = FirebaseAuth.getInstance()
var storedVerificationId = ""

fun signInWithPhoneAuthCredential(context: Context, credential: PhoneAuthCredential, navController: NavController){
    auth.signInWithCredential(credential)
        .addOnCompleteListener(context as Activity) { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                navController.navigate("home")
                val user = task.result?.user
            } else {
                if (task.exception is FirebaseAuthInvalidCredentialsException){
                    Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                }

            }
        }
}

fun onLoginClicked(context: Context, navController: NavController, phoneNumber: String, onCodeSend:() -> Unit){
    auth.setLanguageCode("en")
    val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            Log.d("phoneBook", "Verification Completed")
            signInWithPhoneAuthCredential(context, p0, navController)
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            Log.d("phoneBook", "Verification Failed$p0")

        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            Log.d("phoneBook", "Code Sent$p0")
            storedVerificationId = p0
            onCodeSend()
        }

    }

    val option = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber("+91$phoneNumber")
        .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS)
        .setActivity(context as Activity)
        .setCallbacks(callback)
        .build()
    PhoneAuthProvider.verifyPhoneNumber(option)
}

fun verifyPhoneNumberWithCode(context: Context, verificationId: String, code: String, navController: NavController){
    val p0 = PhoneAuthProvider.getCredential(verificationId, code)
    signInWithPhoneAuthCredential(context, p0, navController)
}