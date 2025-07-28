package com.kiki.githubsearch.di


import com.kiki.githubsearch.data.remote.GithubApi
import com.kiki.githubsearch.data.remote.UserRemoteDataSource
import com.kiki.githubsearch.data.remote.UserRemoteDataSourceImpl
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