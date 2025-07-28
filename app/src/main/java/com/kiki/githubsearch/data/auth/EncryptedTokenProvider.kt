package com.kiki.githubsearch.data.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class EncryptedTokenProvider @Inject constructor(
    @ApplicationContext context: Context
) : TokenProvider {

    private val prefs: SharedPreferences by lazy {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        EncryptedSharedPreferences.create(
            "secure_prefs",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    override fun getToken(): String? {
        return prefs.getString("auth_token", null)
    }

    override fun saveToken(token: String) {
        prefs.edit(){
            putString("auth_token", token).apply()
        }
    }

    override fun clearToken() {
        prefs.edit(){
            remove("auth_token").apply()
        }
    }
}
