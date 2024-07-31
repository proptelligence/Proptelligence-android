package com.proptelligencenet.proptelligence.screens


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.proptelligencenet.proptelligence.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        // After the animation, check if a user is signed in
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // User is signed in, navigate to the home screen
            navController.navigate("home") {
                // Pop up to the splash screen from the back stack
                // and then remove it to prevent going back to the splash screen
                popUpTo("splash") { inclusive = true }
            }
        } else {
            // User is not signed in, navigate to the login screen
            navController.navigate("selectCity") {
                // Pop up to the splash screen from the back stack
                // and then remove it to prevent going back to the splash screen
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Splash(alpha = alphaAnim.value)


}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
//                brush = Brush.verticalGradient(
//                    colors= listOf(
//                        Color(android.graphics.Color.parseColor("#32357A")),
//                        Color(android.graphics.Color.parseColor("#FFFFFF"))
//                    )
//                )
                color = Color(android.graphics.Color.parseColor("#F2F1F6"))
            )
    ) {
        var textOffset by remember { mutableStateOf(0f) }
        val offsetAnim = animateFloatAsState(
            targetValue = if (alpha == 1f) 0f else -20f,
            animationSpec = tween(durationMillis = 1000)
        )

        LaunchedEffect(key1 = alpha) {textOffset = offsetAnim.value
        }

        val logo: Painter = painterResource(id = R.drawable.app_logo)
        Image(
            painter = logo,
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(alpha)
                .size(180.dp)
                .graphicsLayer {
                    translationY = textOffset
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}