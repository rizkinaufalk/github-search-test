package com.kiki.githubsearch.presentation.user.search.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_search.domain.usecases.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.kiki.githubsearch.domain.Result
import com.kiki.githubsearch.presentation.asUiText
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val usersUseCases: UsersUseCases
): ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState

    private var currentPage = 1
    private var endPage = false
    private var lastQuery = ""

    private var searchJob: Job? = null

    private fun searchUsers(query: String, isOnTextChanged: Boolean, isLoadNextPage: Boolean) {

        if (lastQuery == query && !isLoadNextPage && !_uiState.value.isRefreshing) return

        searchJob?.cancel()
        searchJob = viewModelScope.launch {

            if (isOnTextChanged) {
                delay(500)
            }

            if (query != lastQuery) {
                currentPage = 1
                endPage = false
                _uiState.value = _uiState.value.copy(userList = emptyList())
            }

            lastQuery = query

            if (_uiState.value.isLoading || endPage) return@launch
            _uiState.value = _uiState.value.copy(isLoading = true)

            usersUseCases.searchUsers.invoke(query, currentPage, 20).collect { result ->
                when (result) {
                    is Result.Success -> {
                        val newItems = result.data

                        if (newItems.isEmpty()) {
                            endPage = true
                        } else {
                            currentPage++
                        }

                        val updatedList = _uiState.value.userList + newItems
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isRefreshing = false,
                            userList = updatedList,
                            errorMessage = null,
                            currentPage = currentPage
                        )
                    }
                    is Result.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isRefreshing = false,
                            errorMessage = result.error.asUiText()
                        )
                    }
                    Result.Loading -> {
                        _uiState.value = _uiState.value.copy(isLoading = true)
                    }
                }
            }
        }
    }

    fun loadNextPage (){
        searchUsers(_uiState.value.searchText, false, true)
    }

    fun onTextChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchText = query)
        searchUsers(query, true, false)
    }

    fun onSearchClicked() {
        searchUsers(_uiState.value.searchText, false, false)
    }

    fun onPullRefresh() {
        _uiState.update { it.copy(isRefreshing = true, userList = emptyList()) }
        currentPage = 1
        endPage = false
        searchUsers(_uiState.value.searchText, false, false)
    }
}