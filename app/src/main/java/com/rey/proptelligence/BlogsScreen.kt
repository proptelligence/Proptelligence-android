package com.rey.proptelligence

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BlogsScreen(navController: NavController) {

}

@Preview(showBackground = true)
@Composable
fun BlogsScreenPreview() {
    BlogsScreen(rememberNavController())
}