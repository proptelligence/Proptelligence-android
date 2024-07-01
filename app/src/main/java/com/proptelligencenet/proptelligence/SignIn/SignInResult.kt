package com.proptelligencenet.proptelligence.SignIn

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val id: String,
    val name: String?,
    val email: String?,
    val profilePicUrl: String?
)
