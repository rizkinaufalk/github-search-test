package com.kiki.githubsearch.data.datasources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kiki.githubsearch.domain.model.User

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

fun List<UserEntity>.toDomain(): List<User> = map { it.toDomain() }

fun UserEntity.toDomain(): User = User(
    id = id,
    username = username,
    name = name,
    bio = bio,
    email = email,
    company = company,
    twitter = twitter,
    followers = followers,
    following = following,
    avatarUrl = avatarUrl
)
