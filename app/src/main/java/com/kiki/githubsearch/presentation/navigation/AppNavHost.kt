package com.kiki.githubsearch.presentation.navigation

import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig
import com.kiki.githubsearch.presentation.user.detail.UserDetailScreen
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
        composable(
            route = Screen.UserDetails.route,
            arguments = listOf(
                navArgument("username") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val username = backStackEntry.arguments?.getString("username") ?: return@composable

            UserDetailScreen(
                username = username,
                updateToolbar = updateToolbar
            )
        }
    }
}