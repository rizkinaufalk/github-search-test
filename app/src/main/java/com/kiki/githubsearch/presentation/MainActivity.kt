package com.kiki.githubsearch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kiki.githubsearch.presentation.components.toolbar.AppScaffold
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig
import com.kiki.githubsearch.presentation.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val toolbarConfig = remember { mutableStateOf(ToolbarConfig()) }
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppScaffold(
                    toolbarConfig = toolbarConfig.value,
                    onBack = {
                        if (!navController.popBackStack()) finish()
                    },
                    scrollBehavior = scrollBehavior
                ) {
                    AppNavHost(navController = navController) {
                        toolbarConfig.value = it
                    }
                }
            }
        }
    }
}