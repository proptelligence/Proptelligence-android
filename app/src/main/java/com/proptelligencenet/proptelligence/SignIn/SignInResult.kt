package com.proptelligencenet.proptelligence.SignIn

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val customer_id: String? = null,
    val customer_name: String? = null,
    val customer_email: String? = null,
    val customer_phone: String? = null
)
