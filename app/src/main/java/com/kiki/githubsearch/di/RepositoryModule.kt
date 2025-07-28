package com.kiki.githubsearch.di

import com.kiki.githubsearch.data.datasources.remote.UserRemoteDataSource
import com.kiki.githubsearch.data.repositories.UserRepositoryImpl
import com.kiki.githubsearch.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providesUsersRepository(
        remoteDataSource: UserRemoteDataSource
    ): UserRepository = UserRepositoryImpl(remoteDataSource)
}