package com.kiki.githubsearch.data.repositories

import com.kiki.githubsearch.data.datasources.local.UserLocalDataSource
import com.kiki.githubsearch.data.datasources.local.entity.UserEntity
import com.kiki.githubsearch.data.datasources.remote.UserRemoteDataSource
import com.kiki.githubsearch.data.datasources.remote.dto.SearchUsersDto
import com.kiki.githubsearch.data.datasources.remote.dto.UserDetailsDto
import com.kiki.githubsearch.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl  @Inject constructor(
    private val remote: UserRemoteDataSource,
    private val local: UserLocalDataSource
): UserRepository {
    //Remote

    override suspend fun searchUsers(query: String, page: Int, size: Int): SearchUsersDto {
        return remote.searchUsers(query, page, size)
    }

    override suspend fun getUserDetailsByUsername(username: String): UserDetailsDto {
        return remote.getUserDetailsByUsername(username)
    }

    //Local
    override suspend fun insertUserToLocal(user: UserEntity) {
        local.insertUser(user)
    }

    override fun searchLocalUsers(query: String): Flow<List<UserEntity>> = local.searchUsers(query)


    override suspend fun getLocalUserByUsername(username: String): UserEntity? {
        return local.getUserByUsername(username)
    }

    override suspend fun clearLocalUsers() {
        local.clearUsers()
    }
}