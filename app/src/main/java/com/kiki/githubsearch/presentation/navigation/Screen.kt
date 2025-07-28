package com.kiki.githubsearch.presentation.navigation

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object UserDetails : Screen("userDetail/{username}"){
        fun createRoute(username: String) = "userDetail/$username"
    }
}