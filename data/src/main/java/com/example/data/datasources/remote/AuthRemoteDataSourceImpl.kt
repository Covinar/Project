package com.example.data.datasources.remote

import com.example.data.api.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : AuthRemoteDataSource {
    override fun singIn(): Single<Unit> {
        return apiService.singIn()
    }
}