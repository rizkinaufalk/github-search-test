package com.kiki.githubsearch.data.datasources.remote

import com.kiki.githubsearch.data.datasources.remote.dto.SearchUsersDto
import com.kiki.githubsearch.data.datasources.remote.dto.UserDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchUsersDto

    @GET("users/{username}")
    suspend fun getUserDetailsByUsername(
        @Path("username") username: String
    ): UserDetailsDto
}