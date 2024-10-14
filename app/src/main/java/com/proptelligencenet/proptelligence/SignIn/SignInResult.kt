package com.proptelligencenet.proptelligence.SignIn

import com.google.firebase.auth.FirebaseAuth

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

val auth = FirebaseAuth.getInstance()
val user = auth.currentUser

data class UserData(
    val customer_id: String? = user?.uid.toString(),
    val customer_name: String? = null,
    val customer_email: String? = null,
    val customer_phone: String? = null
)
