package com.example.androiddevchallenge.screen.login

data class LoginStatus(
    val email:String="",
    val password:String="",
    val isEmailError:Boolean=false,
    val isPasswordError:Boolean =false
)