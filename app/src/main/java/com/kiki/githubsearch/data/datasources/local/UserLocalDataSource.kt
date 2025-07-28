package com.kiki.githubsearch.data.datasources.local

import com.kiki.githubsearch.data.datasources.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun insertUser(user: UserEntity)

    fun searchUsers(query: String): Flow<List<UserEntity>>

    suspend fun getUserByUsername(username: String): UserEntity?

    suspend fun clearUsers()
}