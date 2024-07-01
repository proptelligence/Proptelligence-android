package com.proptelligencenet.proptelligence

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext



val auth = FirebaseAuth.getInstance()
var storedVerificationId = ""

suspend fun signInWithPhoneAuthCredential(context: Context, credential: PhoneAuthCredential, navController: NavController){
    withContext(Dispatchers.IO) {
        try {
            val result = auth.signInWithCredential(credential).await()
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                navController.navigate("home")
                result.user
            }
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun onLoginClicked(context: Context, navController: NavController, phoneNumber: String, onCodeSend:() -> Unit){
    auth.setLanguageCode("en")
    val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            Log.d("phoneBook", "Verification Completed")
            GlobalScope.launch {
                signInWithPhoneAuthCredential(context, p0, navController)
            }
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

@OptIn(DelicateCoroutinesApi::class)
fun verifyPhoneNumberWithCode(context: Context, verificationId: String, code: String, navController: NavController){
    val p0 = PhoneAuthProvider.getCredential(verificationId, code)
    GlobalScope.launch {
        signInWithPhoneAuthCredential(context, p0, navController)
    }
}