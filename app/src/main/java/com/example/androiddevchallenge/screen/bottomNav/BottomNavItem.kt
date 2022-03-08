package com.example.androiddevchallenge.screen.bottomNav

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.androiddevchallenge.screen.Screen

@Immutable
data class BottomNavItem(val screen: Screen, @StringRes val labelResourceId: Int, val icon: ImageVector)