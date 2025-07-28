package com.kiki.githubsearch.domain.repository

import com.kiki.githubsearch.data.datasources.local.entity.UserEntity
import com.kiki.githubsearch.data.datasources.remote.dto.SearchUsersDto
import com.kiki.githubsearch.data.datasources.remote.dto.UserDetailsDto
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    //Remote
    suspend fun searchUsers(query: String, page: Int, size: Int): SearchUsersDto

    suspend fun getUserDetailsByUsername(username: String): UserDetailsDto

    // Local
    suspend fun insertUserToLocal(user: UserEntity)

    fun searchLocalUsers(query: String): Flow<List<UserEntity>>

    suspend fun getLocalUserByUsername(username: String): UserEntity?

    suspend fun clearLocalUsers()
}