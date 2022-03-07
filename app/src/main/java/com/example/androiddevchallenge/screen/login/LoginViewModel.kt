package com.example.androiddevchallenge.screen.login

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginState = mutableStateOf<LoginStatus>(LoginStatus())
    val loginState: State<LoginStatus> get() = _loginState

    private val _navigateToHome = mutableStateOf<Boolean>(false)
    val navigateToHome: State<Boolean> get() = _navigateToHome

    fun onChangeEmail(email: String) {

        _loginState.value = _loginState.value.copy(
            email = email,
            isEmailError = false
        )
    }

    fun onChangePassword(password: String) {

        _loginState.value = _loginState.value.copy(
            password = password,
            isPasswordError = false
        )
    }

    private fun validateEmail(): Boolean {

        val email = _loginState.value.email
        val isValidate = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (isValidate.not()) {
            _loginState.value = _loginState.value.copy(
                isEmailError = true
            )
        }

        return isValidate
    }

    private fun validatePassword(): Boolean {
        val password = _loginState.value.password
        val passwordValid = password.length >= 8

        if (passwordValid) {
            _loginState.value = _loginState.value.copy(
                isPasswordError = false
            )
        } else {

            _loginState.value = _loginState.value.copy(
                isPasswordError = true
            )
        }

        return passwordValid
    }

    fun onClickedLoginButton() {
        val isValidEmail = validateEmail()
        val isValidPassword = validatePassword()

        if (isValidEmail && isValidPassword) {
            _navigateToHome.value = true
        }
    }

    fun displayedHomeScreen() {
        _navigateToHome
            .value = false
    }


}