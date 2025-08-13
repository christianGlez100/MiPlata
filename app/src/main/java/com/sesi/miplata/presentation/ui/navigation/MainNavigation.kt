package com.sesi.miplata.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sesi.miplata.presentation.ui.screen.categories.catalog.CatalogCategoriesScreen
import com.sesi.miplata.presentation.ui.screen.home.HomeScreen
import com.sesi.miplata.presentation.ui.screen.settings.SettingsScreen

@Composable
fun MainNavigation(rootNavController: NavHostController) {
    NavHost(navController = rootNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }
        composable(route = Routes.Settings.route) {
            SettingsScreen(rootNavController)
        }
        composable(route = Routes.Categories.route) {
            CatalogCategoriesScreen()
        }


    }
}