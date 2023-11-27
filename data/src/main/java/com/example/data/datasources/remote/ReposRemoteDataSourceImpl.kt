package com.example.data.datasources.remote

import com.example.data.api.ApiService
import com.example.data.dto.RepositoryDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ReposRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : ReposRemoteDataSource{

    override fun getRepositories(perPage: Int, page: Int): Single<List<RepositoryDto>> {
        return apiService.getRepositories(perPage, page)
    }

}