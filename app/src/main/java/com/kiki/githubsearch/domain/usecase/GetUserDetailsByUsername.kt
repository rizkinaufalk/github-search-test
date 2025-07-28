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
import javax.inject.Inject

class GetUserDetailsByUsername @Inject constructor(
    private val usersRepository: UserRepository
) {
    operator fun invoke(username: String): Flow<Result<User, DataError>> = flowResult {
        try {
            val remoteUser = usersRepository.getUserDetailsByUsername(username)
            val domainUser = remoteUser.toDomain()

            usersRepository.insertUserToLocal(domainUser.toEntity())

            domainUser
        } catch (remoteError: Throwable) {

            usersRepository.getLocalUserByUsername(username)
                ?.toDomain()
                ?: throw remoteError
        }
    }
}