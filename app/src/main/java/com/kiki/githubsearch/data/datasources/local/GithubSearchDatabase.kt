package com.kiki.githubsearch.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kiki.githubsearch.data.datasources.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GithubSearchDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}