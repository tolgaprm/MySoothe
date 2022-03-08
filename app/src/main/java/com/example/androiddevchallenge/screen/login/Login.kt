package com.example.androiddevchallenge.screen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.MySootheButton
import com.example.androiddevchallenge.components.MySootheTextField
import com.example.androiddevchallenge.screen.Screen
import com.example.androiddevchallenge.ui.theme.Taupe100
import com.example.androiddevchallenge.ui.theme.Taupe800

@Composable
fun Login(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                color = if (isSystemInDarkTheme()) Color.Taupe100 else Color.Taupe800
            )

            MySootheTextField(
                modifier = Modifier.fillMaxWidth(),
                value = loginViewModel.loginState.value.email,
                onValueChange = { loginViewModel.onChangeEmail(it) },
                placeholder = { Text(text = stringResource(R.string.login_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = loginViewModel.loginState.value.isEmailError
            )
            AnimatedVisibility(visible = loginViewModel.loginState.value.isEmailError) {
                Text(
                    text = stringResource(R.string.invalid_email),
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            MySootheTextField(
                modifier = Modifier.fillMaxWidth(),
                value = loginViewModel.loginState.value.password,
                onValueChange = { loginViewModel.onChangePassword(it) },
                placeholder = { Text(text = stringResource(R.string.login_password)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = loginViewModel.loginState.value.isPasswordError,
                visualTransformation = PasswordVisualTransformation()
            )
            AnimatedVisibility(visible = loginViewModel.loginState.value.isPasswordError) {
                Text(
                    text = stringResource(R.string.invalid_password),
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            MySootheButton(onClick = {
                loginViewModel.onClickedLoginButton()
                if (loginViewModel.navigateToHome.value) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Welcome.route) {
                            inclusive = true
                        }
                    }
                    loginViewModel.displayedHomeScreen()
                }
            }) {
                Text(text = stringResource(id = R.string.login).uppercase())
            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.login_dont_have_account),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFromBaseline(32.dp),
                    color = if (isSystemInDarkTheme()) Color.Taupe100 else Color.Taupe800
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.login_sign_up),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFromBaseline(32.dp),
                    textDecoration = TextDecoration.Underline,
                    color = if (isSystemInDarkTheme()) Color.Taupe100 else Color.Taupe800
                )
            }


        }

    }

}