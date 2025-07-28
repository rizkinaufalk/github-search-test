package com.kiki.githubsearch.presentation.user.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kiki.githubsearch.presentation.components.CharacterHeader
import com.kiki.githubsearch.presentation.components.CustomPullToRefreshBox
import com.kiki.githubsearch.presentation.components.RowTitleDesc
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    username: String = "",
    viewModel: DetailViewModel = hiltViewModel(),
    updateToolbar: (ToolbarConfig) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    LaunchedEffect(username) {
        viewModel.getUserDetailByUsername(username)
        updateToolbar(ToolbarConfig(title = "Details"))
    }

    Surface (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CustomPullToRefreshBox(
            isRefreshing = uiState.isRefreshing,
            onRefresh = viewModel::onPullRefresh
        ) {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                CharacterHeader(
                    imageUrl = uiState.userDetail.avatarUrl.orEmpty(),
                    name = uiState.userDetail.name.orEmpty()
                )

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                ){

                    RowTitleDesc("Username", uiState.userDetail.username ?: "-")
                    RowTitleDesc("Bio", uiState.userDetail.bio ?: "-")
                    RowTitleDesc("Email", uiState.userDetail.email ?: "-")
                    RowTitleDesc("Followers", uiState.userDetail.followers.toString())
                    RowTitleDesc("Following", uiState.userDetail.following.toString())
                    RowTitleDesc("Company", uiState.userDetail.company ?: "-")
                    RowTitleDesc("Twitter", uiState.userDetail.twitter ?: "-")
                }
            }
        }
    }
}