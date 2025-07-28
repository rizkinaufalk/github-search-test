package com.kiki.githubsearch.data.repositories

import com.kiki.githubsearch.data.datasources.remote.UserRemoteDataSource
import com.kiki.githubsearch.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl  @Inject constructor(
    private val remote: UserRemoteDataSource,
): UserRepository {
}