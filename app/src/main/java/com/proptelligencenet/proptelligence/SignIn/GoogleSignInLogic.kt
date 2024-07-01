package com.proptelligencenet.proptelligence.SignIn

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.GoogleAuthProvider
import com.proptelligencenet.proptelligence.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class GoogleSignInLogic(private val context: Context, private val navController: NavController) {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(context.getString(R.string.web_client_id))
        .requestEmail()
        .build()

    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)

    suspend fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        withContext(Dispatchers.IO) {
            try {
                val result = auth.signInWithCredential(credential).await()
                withContext(Dispatchers.Main) {
                    // User is signed in
                    navController.navigate("home")

                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                    // Create a new user data class
                    val userData = result.user?.uid?.let {
                        UserData(
                            id = it,
                            name = result.user?.displayName,
                            email = result.user?.email,
                            profilePicUrl = result.user?.photoUrl.toString()
                        )
                    }
                    // TODO: Store userData for later use
                }
            }catch (e: CancellationException) {
                // Handle CancellationException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Sign in was cancelled", Toast.LENGTH_LONG).show()
                }
            } catch (e: ApiException) {
                // Handle ApiException
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Google Sign In failed: ${e.statusCode}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: FirebaseNetworkException) {
                // Handle FirebaseNetworkException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Network error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                // Handle FirebaseAuthInvalidCredentialsException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Invalid credentials: ${e.message}", Toast.LENGTH_LONG)
                        .show()
                }
            } catch (e: FirebaseAuthInvalidUserException) {
                // Handle FirebaseAuthInvalidUserException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Invalid user: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } catch (e: FirebaseAuthUserCollisionException) {
                // Handle FirebaseAuthUserCollisionException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "User collision: ${e.message}", Toast.LENGTH_LONG)
                        .show()
                }
            } catch (e: FirebaseTooManyRequestsException) {
                // Handle FirebaseTooManyRequestsException
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Too many requests: ${e.message}", Toast.LENGTH_LONG)
                        .show()
                }
            } catch (e: Exception) {
                // Handle other exceptions
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Login failed: ${e.message}", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}