package com.example.data.datasources.local

import android.content.SharedPreferences
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(
    private val sPref: SharedPreferences
) : AuthLocalDataSource {

    override fun saveToken(token: String) {
        sPref.edit().putString(EXTRA_TOKEN, token).apply()
    }

    override fun getToken(): String {
        return sPref.getString(EXTRA_TOKEN, "") ?: ""
    }

    companion object {
        private const val EXTRA_TOKEN = "extra_token"
    }

}