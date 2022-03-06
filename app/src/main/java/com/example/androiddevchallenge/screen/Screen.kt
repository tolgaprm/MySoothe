package com.example.androiddevchallenge.screen

import androidx.compose.runtime.Immutable

sealed class Screen(val route: String) {

    @Immutable
    object Welcome : Screen("Welcome")

    @Immutable
    object Login : Screen("Login")

    @Immutable
    object Home : Screen("Home")

    @Immutable
    object Profile : Screen("Profile")

}
