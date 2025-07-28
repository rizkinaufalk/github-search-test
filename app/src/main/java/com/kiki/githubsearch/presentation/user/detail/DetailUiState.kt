package com.kiki.githubsearch.presentation.user.detail

import com.kiki.githubsearch.domain.model.User
import com.kiki.githubsearch.presentation.UiText

data class DetailUiState(
    val username: String? = null,
    val userDetail: User = User(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val isRefreshing: Boolean = false
)