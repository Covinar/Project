package com.example.data.datasources.local

interface AuthLocalDataSource {

    fun saveToken(token: String)

    fun getToken() : String

}