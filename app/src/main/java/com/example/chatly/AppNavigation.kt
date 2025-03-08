package com.example.chatly

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatly.screens.LandingPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") { LandingPage {
            navController.navigate("login")
        }}
        composable("login") { LoginPage(NavigationHelper(navController)) }
        composable("signup") { SignUpPage(NavigationHelper(navController)) }

    }
}

class NavigationHelper(private val navController: NavController) {

    fun navigateToSignUp() {
        navController.navigate("signup")
    }

    fun navigateToLogin() {
        navController.navigate("login")
    }

}