package com.example.data.datasources.remote

import com.example.data.api.ApiService
import com.example.data.dto.RepositoryDto
import retrofit2.Response
import javax.inject.Inject

class ReposRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : ReposRemoteDataSource{

    override suspend fun getRepositories(): Response<List<RepositoryDto>> {
        return apiService.getRepositories()
    }

}