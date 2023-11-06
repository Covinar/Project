package com.example.data.datasources.local

interface AuthLocalDataSource {

    fun saveIsSignedIn(isSignedIn: Boolean)

    fun isSignedIn(): Boolean

    fun saveToken(token: String)

    fun getToken(): String

}