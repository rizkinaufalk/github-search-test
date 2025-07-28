package com.kiki.githubsearch.data.datasources.remote

import com.kiki.githubsearch.data.datasources.remote.dto.SearchUsersDto
import com.kiki.githubsearch.data.datasources.remote.dto.UserDetailsDto

interface UserRemoteDataSource {

    suspend fun searchUsers(query: String, page: Int, size: Int): SearchUsersDto

    suspend fun getUserDetailsByUsername(username: String): UserDetailsDto
}