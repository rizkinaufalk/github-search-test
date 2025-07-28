package com.kiki.githubsearch.data.remote

import javax.inject.Inject

class UserRemoteDataSourceImpl  @Inject constructor(
    private val githubApi: GithubApi
): UserRemoteDataSource {

}