package com.sesi.miplata.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sesi.miplata.presentation.ui.screen.home.HomeScreen

@Composable
fun MainNavigation(rootNavController: NavHostController) {
    NavHost(navController = rootNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }

    }
}