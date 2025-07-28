package com.kiki.githubsearch.data.datasources.local

import com.kiki.githubsearch.data.datasources.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalDataSourceImpl  @Inject constructor(
    private val local: UserDao
) : UserLocalDataSource {

    override suspend fun insertUser(user: UserEntity) {
        local.insert(user)
    }

    override fun searchUsers(query: String): Flow<List<UserEntity>> = local.searchUsers(query)


    override suspend fun getUserByUsername(username: String): UserEntity? {
        return local.getUserByUsername(username)
    }

    override suspend fun clearUsers() {
        local.clearUsers()
    }
}