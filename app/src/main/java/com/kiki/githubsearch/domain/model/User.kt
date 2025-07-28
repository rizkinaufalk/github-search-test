package com.kiki.githubsearch.domain.model

import com.kiki.githubsearch.data.datasources.local.entity.UserEntity


data class User(
    val id: Int? = 0,
    val username: String? = "",
    val name: String? = "",
    val bio: String? = "",
    val email: String? = "",
    val company: String? = "",
    val twitter: String? = "",
    val followers: Int? = 0,
    val following: Int? = 0,
    val avatarUrl: String? = "",
)

fun User.toEntity(): UserEntity = UserEntity(
    id = id ?: 0,
    username = username,
    name = name,
    bio = bio,
    email = email,
    company = company,
    twitter = twitter,
    followers = followers,
    following = following,
    avatarUrl = avatarUrl,
)