package com.kiki.githubsearch.presentation.navigation

import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.composable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig

@Composable
fun AppNavHost(
    navController: NavHostController,
    updateToolbar: (ToolbarConfig) -> Unit
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

    }
}