package com.kiki.githubsearch

import android.app.Application
import com.kiki.githubsearch.data.auth.TokenProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GithubSearchApp: Application() {
    @Inject
    lateinit var tokenProvider: TokenProvider

    override fun onCreate() {
        super.onCreate()

        if (tokenProvider.getToken() == null) {
            tokenProvider.saveToken(BuildConfig.GITHUB_TOKEN)
        }
    }
}