package com.example.androiddevchallenge

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.Screen
import com.example.androiddevchallenge.screen.WelcomeScreen
import com.example.androiddevchallenge.screen.bottomNav.BottomNavItem
import com.example.androiddevchallenge.screen.bottomNav.MySootheBottomNavTheme
import com.example.androiddevchallenge.screen.home.HomeScreen
import com.example.androiddevchallenge.screen.login.Login
import com.example.androiddevchallenge.screen.profile.ProfileScreen
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun MySootheApp() {
    ProvideWindowInsets {

        val navBarItems = listOf(
            BottomNavItem(Screen.Home, R.string.nav_home_label, Icons.Filled.Spa),
            BottomNavItem(Screen.Profile, R.string.nav_profile_label, Icons.Filled.AccountCircle)
        )

        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            modifier = Modifier.navigationBarsPadding(),
            bottomBar = {
                navBarItems.forEach { bottomNavItem ->
                    if (bottomNavItem.screen.route == currentDestination?.route) {
                        MySootheBottomNavTheme {
                            BottomNavigation {
                                navBarItems.forEach { bottomNavItem ->
                                    BottomNavigationItem(
                                        icon = {
                                            Icon(
                                                bottomNavItem.icon,
                                                contentDescription = stringResource(id = bottomNavItem.labelResourceId),
                                                modifier = Modifier.size(18.dp)
                                            )
                                        },
                                        label = { Text(stringResource(bottomNavItem.labelResourceId)) },
                                        selected = currentDestination.hierarchy.any { it.route == bottomNavItem.screen.route },
                                        onClick = {
                                            navController.navigate(bottomNavItem.screen.route) {
                                                // Pop up to the start destination of the graph to
                                                // avoid building up a large stack of destinations
                                                // on the back stack as users select items
                                                popUpTo(Screen.Home.route)
                                                // Avoid multiple copies of the same destination when
                                                // reselecting the same item
                                                launchSingleTop = true
                                                // Restore state when reelecting a previously selected item
                                                restoreState = true
                                            }
                                        }
                                    )
                                }
                            }
                        }

                    }
                }

            },
            floatingActionButton = { navBarItems.forEach { if (it.screen.route == currentDestination?.route) FloatingActionButton() } },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) {
            Navigation(navController)
        }

    }
}

@Composable
fun FloatingActionButton() {

    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = null)
    }

}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }

        composable(Screen.Login.route) {
            Login(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)

        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }

}