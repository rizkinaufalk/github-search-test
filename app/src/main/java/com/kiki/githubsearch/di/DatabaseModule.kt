package com.kiki.githubsearch.di

import android.content.Context
import androidx.room.Room
import com.kiki.githubsearch.data.datasources.local.GithubSearchDatabase
import com.kiki.githubsearch.data.datasources.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GithubSearchDatabase {
        return Room.databaseBuilder(
            context,
            GithubSearchDatabase::class.java,
            "github_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(db: GithubSearchDatabase): UserDao {
        return db.userDao()
    }
}