package com.kiki.githubsearch.data.datasources.remote.dto

import com.kiki.githubsearch.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchUsersDto(
    val incomplete_results: Boolean? = null,
    val items: List<Item>? = null,
    val total_count: Int? = null
)



fun SearchUsersDto.toDomain(): List<User> {
    return items?.map {
        it.searchToDomain()
    } ?: emptyList()
}