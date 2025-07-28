package com.kiki.githubsearch.di


import com.kiki.githubsearch.data.datasources.remote.GithubApi
import com.kiki.githubsearch.data.datasources.remote.UserRemoteDataSource
import com.kiki.githubsearch.data.datasources.remote.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Singleton
    @Provides
    fun providesUsersRemoteDataSource (
        githubApi: GithubApi
    ): UserRemoteDataSource = UserRemoteDataSourceImpl(githubApi)
}