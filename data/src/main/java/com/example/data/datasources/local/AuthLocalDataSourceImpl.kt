package com.example.data.datasources.local

import android.content.SharedPreferences
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(
    private val sPref: SharedPreferences
) : AuthLocalDataSource {
    override fun saveIsSignedIn(isSignedIn: Boolean) {
        sPref.edit().putBoolean(EXTRA_SIGNED_IN, isSignedIn).apply()
    }

    override fun isSignedIn(): Boolean {
        return sPref.getBoolean(EXTRA_SIGNED_IN, false)
    }


    override fun saveToken(token: String) {
        sPref.edit().putString(EXTRA_TOKEN, token).apply()
    }

    override fun getToken(): String {
        return sPref.getString(EXTRA_TOKEN, "") ?: ""
    }

    companion object {
        private const val EXTRA_TOKEN = "extra_token"
        private const val EXTRA_SIGNED_IN = "extra_signed_in"
    }

}