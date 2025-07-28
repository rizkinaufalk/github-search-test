package com.kiki.githubsearch.domain.usecase

import com.kiki.githubsearch.data.datasources.local.entity.toDomain
import com.kiki.githubsearch.data.datasources.remote.dto.toDomain
import com.kiki.githubsearch.domain.DataError
import com.kiki.githubsearch.domain.Result
import com.kiki.githubsearch.domain.flowResult
import com.kiki.githubsearch.domain.model.User
import com.kiki.githubsearch.domain.model.toEntity
import com.kiki.githubsearch.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SearchUsers @Inject constructor(
    private val usersRepository: UserRepository
) {
    operator fun invoke(query: String, page: Int, size: Int): Flow<Result<List<User>, DataError>> = flowResult {

        val localUsers = usersRepository.searchLocalUsers(query)
            .first()
            .map { it.toDomain() }

        if (localUsers.isNotEmpty()) {
            localUsers
        } else {

            val remoteUsers = usersRepository.searchUsers(query, page, size).toDomain()
            remoteUsers.forEach { user ->
                usersRepository.insertUserToLocal(user.toEntity())
            }
            remoteUsers
        }
    }
}
