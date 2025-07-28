package com.kiki.githubsearch.di.network

import com.kiki.githubsearch.data.auth.EncryptedTokenProvider
import com.kiki.githubsearch.data.auth.TokenProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TokenProviderModule {

    @Binds
    abstract fun bindTokenProvider(
        impl: EncryptedTokenProvider
    ): TokenProvider
}