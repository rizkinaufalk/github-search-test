package com.kiki.githubsearch.presentation.user.search.search

import com.kiki.githubsearch.domain.model.User
import com.kiki.githubsearch.presentation.UiText

data class SearchUiState(
    val userList: List<User> = emptyList(),
    val searchText: String = "",
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val currentPage: Int = 1,
    val endPage: Boolean = false,
    val isRefreshing: Boolean = false
)