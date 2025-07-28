package com.kiki.githubsearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig
import com.kiki.githubsearch.presentation.user.search.search.SearchScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    updateToolbar: (ToolbarConfig) -> Unit
) {
    NavHost(navController = navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(
                onNavigateToDetail = { username ->
                    navController.navigate(Screen.UserDetails.createRoute(username))
                },
                updateToolbar = updateToolbar
            )
        }
    }
}