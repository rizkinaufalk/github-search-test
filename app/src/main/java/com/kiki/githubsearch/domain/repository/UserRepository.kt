package com.kiki.githubsearch.domain.repository

import com.kiki.githubsearch.data.datasources.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {



    // Local
    suspend fun insertUserToLocal(user: UserEntity)

    fun searchLocalUsers(query: String): Flow<List<UserEntity>>

    suspend fun getLocalUserByUsername(username: String): UserEntity?

    suspend fun clearLocalUsers()
}