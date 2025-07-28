package com.kiki.githubsearch.data.datasources.remote

import com.kiki.githubsearch.data.datasources.remote.dto.SearchUsersDto
import com.kiki.githubsearch.data.datasources.remote.dto.UserDetailsDto
import javax.inject.Inject

class UserRemoteDataSourceImpl  @Inject constructor(
    private val githubApi: GithubApi
): UserRemoteDataSource {

    override suspend fun searchUsers(query: String, page: Int, size: Int): SearchUsersDto {
        return githubApi.searchUsers(query, page, size)
    }

    override suspend fun getUserDetailsByUsername(username: String): UserDetailsDto {
        return githubApi.getUserDetailsByUsername(username)
    }
}