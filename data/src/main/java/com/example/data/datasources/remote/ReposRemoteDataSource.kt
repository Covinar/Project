package com.example.data.datasources.remote

import com.example.data.dto.RepositoryDto
import retrofit2.Response

interface ReposRemoteDataSource {

    suspend fun getRepositories() : Response<List<RepositoryDto>>

}