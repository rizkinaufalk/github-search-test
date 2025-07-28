package com.kiki.githubsearch.di

import com.kiki.githubsearch.data.datasources.local.UserDao
import com.kiki.githubsearch.data.datasources.local.UserLocalDataSource
import com.kiki.githubsearch.data.datasources.local.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun providesUsersLocalDataSource (
        userDao: UserDao
    ): UserLocalDataSource = UserLocalDataSourceImpl(userDao)
}