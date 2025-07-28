package com.kiki.githubsearch.data.datasources.remote.dto

import com.kiki.githubsearch.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val avatar_url: String? = null,
    val events_url: String? = null,
    val followers_url: String? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val gravatar_id: String? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val login: String? = null,
    val node_id: String? = null,
    val organizations_url: String? = null,
    val received_events_url: String? = null,
    val repos_url: String? = null,
    val score: Int? = null,
    val site_admin: Boolean? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val type: String? = null,
    val url: String? = null,
    val user_view_type: String? = null
)

fun Item.searchToDomain(): User {
    return User(
        id = id,
        username = login,
        avatarUrl = avatar_url
    )
}