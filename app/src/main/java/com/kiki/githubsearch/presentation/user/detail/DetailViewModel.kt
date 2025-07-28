package com.kiki.githubsearch.presentation.user.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_search.domain.usecases.UsersUseCases
import javax.inject.Inject
import com.kiki.githubsearch.domain.Result
import com.kiki.githubsearch.domain.model.User
import com.kiki.githubsearch.presentation.asUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val usersUseCases: UsersUseCases
): ViewModel() {

    private var _uiState = MutableStateFlow(DetailUiState())
    var uiState: StateFlow<DetailUiState> = _uiState

    fun getUserDetailByUsername(username: String){
        _uiState.value = _uiState.value.copy(isLoading = true, username = username)
        viewModelScope.launch {
            usersUseCases.getUserDetailsByUsername(_uiState.value.username.orEmpty()).collect{ result ->
                when(result){
                    is Result.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isRefreshing = false,
                            userDetail = User(
                                id = result.data.id,
                                avatarUrl = result.data.avatarUrl,
                                username = result.data.username,
                                name = result.data.name,
                                bio = result.data.bio,
                                email = result.data.email,
                                company = result.data.company,
                                twitter = result.data.twitter,
                                followers = result.data.followers,
                                following = result.data.following
                            )
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

    fun onPullRefresh(){
        _uiState.value = _uiState.value.copy(isRefreshing = true)
        getUserDetailByUsername(_uiState.value.username.orEmpty())
    }
}