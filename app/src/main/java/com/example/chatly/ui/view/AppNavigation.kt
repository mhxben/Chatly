package com.example.chatly.ui.theme.View

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatly.ui.view.LoginPage
import com.example.chatly.ui.view.SignUpPage
import com.example.chatly.view.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") { LandingPage {
            navController.navigate("login")
        }
        }
        composable("login") { LoginPage(NavigationHelper(navController)) }
        composable("signup") { SignUpPage(NavigationHelper(navController)) }
        composable("home") { HomePage(navController) }

    }
}

class NavigationHelper(private val navController: NavController) {

    fun navigateToSignUp() {
        navController.navigate("signup")
    }

    fun navigateToLogin() {
        navController.navigate("login")
    }

    fun navigateToHomePage(){
        navController.navigate("home")
    }

}