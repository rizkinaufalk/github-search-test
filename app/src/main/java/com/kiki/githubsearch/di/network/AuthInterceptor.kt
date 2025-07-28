package com.kiki.githubsearch.di.network

import com.kiki.githubsearch.data.auth.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider.getToken()
        println("🔐 AuthInterceptor | token = $token") // Debug only

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "token $token") // ✅ NOT "Bearer"
            .build()

        return chain.proceed(request)
    }
}
