package com.example.github_search.domain.usecases

import com.kiki.githubsearch.domain.usecase.GetUserDetailsByUsername
import com.kiki.githubsearch.domain.usecase.SearchUsers
import javax.inject.Inject

class UsersUseCases @Inject constructor(
    val searchUsers: SearchUsers,
    val getUserDetailsByUsername: GetUserDetailsByUsername
)