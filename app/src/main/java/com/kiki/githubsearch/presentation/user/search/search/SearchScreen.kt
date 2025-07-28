package com.kiki.githubsearch.presentation.user.search.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kiki.githubsearch.presentation.components.UserListItem
import com.kiki.githubsearch.presentation.components.CustomPullToRefreshBox
import com.kiki.githubsearch.presentation.components.CustomSearchBar
import com.kiki.githubsearch.presentation.components.toolbar.ToolbarConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onNavigateToDetail: (String) -> Unit,
    updateToolbar: (ToolbarConfig) -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
            updateToolbar(ToolbarConfig(title = "Search"))
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                val lastVisibleIndex = visibleItems.lastOrNull()?.index ?: return@collect

                val isAtEnd = lastVisibleIndex >= uiState.userList.lastIndex
                val canLoadMore = !uiState.isLoading && !uiState.endPage

                if (isAtEnd && canLoadMore) {
                    viewModel.loadNextPage()
                }
            }
    }

    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            CustomSearchBar(
                searchText = uiState.searchText,
                onTextChange = viewModel::onTextChanged,
                onSearchClicked = viewModel::onSearchClicked
            )

            when {
                uiState.isLoading && uiState.userList.isEmpty() -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                else -> {
                    CustomPullToRefreshBox(
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = viewModel::onPullRefresh
                    ) {
                        val uniqueUsers = uiState.userList.distinctBy { it.id }

                        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
                            itemsIndexed(uniqueUsers, key = { _, item -> item.id ?: 0 }) { _, user ->
                                UserListItem(
                                    imageUrl = user.avatarUrl.orEmpty(),
                                    name = user.username.orEmpty(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                        .clickable { user.username.let { onNavigateToDetail(it.orEmpty()) } }
                                )
                            }

                            if (uiState.isLoading) {
                                item {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}