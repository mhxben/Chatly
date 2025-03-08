package com.example.chatly

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
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