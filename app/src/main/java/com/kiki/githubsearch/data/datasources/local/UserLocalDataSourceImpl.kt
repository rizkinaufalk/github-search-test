package com.kiki.githubsearch.data.datasources.local

import javax.inject.Inject

class UserLocalDataSourceImpl  @Inject constructor(
    private val local: UserDao
) : UserLocalDataSource {

}