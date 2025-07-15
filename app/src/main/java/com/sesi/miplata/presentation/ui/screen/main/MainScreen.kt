package com.sesi.miplata.presentation.ui.screen.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sesi.miplata.presentation.ui.components.BottomNavigationBar
import com.sesi.miplata.presentation.ui.components.MiPlataTopBar
import com.sesi.miplata.presentation.ui.navigation.MainNavigation
import com.sesi.miplata.presentation.ui.navigation.NavigationItem
import com.sesi.miplata.presentation.ui.navigation.Routes
import com.sesi.miplata.presentation.ui.navigation.navigationItemsLists

@Preview(name = "Light Mode", showBackground = true, showSystemUi = true)
@Preview(name = "Dark Mode", showBackground = true, showSystemUi = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreen() {
    val rootNavController = rememberNavController()
    val navBackStackEntry = rootNavController.currentBackStackEntry

    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route ?: ""
        }
    }
    val navigationItem by remember {
        derivedStateOf {
            navigationItemsLists.find { it.route == currentRoute }
        }
    }
    val isBottomBarVisible by remember(navigationItem) {
        derivedStateOf {
            navigationItem?.route != Routes.Home.route
        }
    }
    val title by remember {
        derivedStateOf { navigationItem?.title ?: "" }
    }


    /*AnimatedVisibility(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        visible = isBottomBarVisible,
        enter = slideInVertically { fullWidth -> -fullWidth },
        exit = slideOutVertically { fullHeight -> -fullHeight }) { }*/
    Scaffold(
        topBar = {
            MiPlataTopBar(
                title = title,
                isBackVisible = false
            ) {}
        },
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomBarVisible,
                enter = slideInVertically { fullHeight -> fullHeight },
                exit = slideOutVertically { fullHeight -> fullHeight }
            ) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = currentRoute,
                    onItemClick = { currentNavigationItem ->
                        onItemClick(rootNavController, currentNavigationItem)
                    })
            }
        }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            MainNavigation(rootNavController = rootNavController)
        }
    }
}

private fun onItemClick(rootNavController: NavHostController, currentNavigationItem: NavigationItem) {
    rootNavController.navigate(currentNavigationItem.route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        rootNavController.graph.startDestinationRoute?.let { startDestinationRoute ->
            // Pop up to the start destination, clearing the back stack
            popUpTo(startDestinationRoute) {
                // Save the state of popped destinations
                saveState = true
            }
        }

        // Configure navigation to avoid multiple instances of the same destination
        launchSingleTop = true

        // Restore state when re-selecting a previously selected item
        restoreState = true
    }
}