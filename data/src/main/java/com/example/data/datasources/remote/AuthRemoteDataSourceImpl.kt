package com.example.data.datasources.remote

import com.example.data.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : AuthRemoteDataSource {
    override suspend fun singIn(): Response<Unit> {
        return apiService.singIn()
    }
}