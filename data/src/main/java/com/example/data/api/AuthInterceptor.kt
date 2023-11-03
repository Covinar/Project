package com.example.data.api

import com.example.data.api.ApiConstants.AUTH_HEADER
import com.example.data.datasources.local.AuthLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val authLocalDataSource: AuthLocalDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
        val token = authLocalDataSource.getToken()
        val request = if (token.isEmpty()) {
            builder.build()
        } else {
            builder.header(AUTH_HEADER, "Bearer $token").build()
        }
        return chain.proceed(request)
    }

}