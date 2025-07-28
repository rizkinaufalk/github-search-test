package com.kiki.githubsearch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GithubSearchApp: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}