package com.sesi.miplata.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(var route: String) {
    data object Home : Routes("home")
    data object Balance : Routes("balance")
    data object Settings : Routes("settings")
    data object Categories : Routes("categories")
}

val navigationItemsLists = listOf(
    NavigationItem(
        unSelectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        title = "Home",
        route = Routes.Home.route
    ),
    NavigationItem(
        unSelectedIcon = Icons.Outlined.AccountBalance,
        selectedIcon = Icons.Filled.AccountBalance,
        title = "Balance",
        route = Routes.Balance.route
    ),
    NavigationItem(
        unSelectedIcon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
        title = "Settings",
        route = Routes.Settings.route
    )
)

data class NavigationItem(
    val unSelectedIcon: ImageVector /* or  DrawableResource*/,
    val selectedIcon: ImageVector /* or  DrawableResource*/,
    val title: String /* or  StringResource  */,
    val route : String
)