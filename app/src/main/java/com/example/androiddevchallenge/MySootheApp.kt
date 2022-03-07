package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.Screen
import com.example.androiddevchallenge.screen.WelcomeScreen
import com.example.androiddevchallenge.screen.home.HomeScreen
import com.example.androiddevchallenge.screen.login.Login
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun MySootheApp() {
    ProvideWindowInsets {
        Navigation()
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Welcome.route) {

        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }

        composable(Screen.Login.route) {
            Login(navController = navController)
        }
        
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }
    }

}