package com.proptelligencenet.proptelligence.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
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
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF32357A),
                        Color(0xFFFFFFFF)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        var textOffset by remember { mutableStateOf(0f) }
        val offsetAnim = animateFloatAsState(
            targetValue = if (alpha == 1f) 0f else -20f,
            animationSpec = tween(durationMillis = 1000)
        )

        LaunchedEffect(key1 = alpha) { textOffset = offsetAnim.value }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "PROPTELLIGENCE",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .alpha(alpha)
                    .graphicsLayer { translationY = textOffset }
            )

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Google Sign In",
                    modifier = Modifier
                        .alpha(alpha)
                        .size(25.dp)
                        .scale(alpha) // Added scaling effect
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "1 YEAR ANNIVERSARY",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier
                        .alpha(alpha)
                        .scale(alpha) // Added scaling effect
                )
            }
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}
