package com.kiki.githubsearch.data.datasources.remote

import javax.inject.Inject

class UserRemoteDataSourceImpl  @Inject constructor(
    private val githubApi: GithubApi
): UserRemoteDataSource {

}