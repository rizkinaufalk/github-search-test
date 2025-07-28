package com.kiki.githubsearch.data.datasources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val username: String?,
    val name: String?,
    val bio: String?,
    val email: String?,
    val company: String?,
    val twitter: String?,
    val followers: Int?,
    val following: Int?,
    val avatarUrl: String?
)
