package com.example.data.datasources.remote

import com.example.data.dto.RepositoryDto
import io.reactivex.rxjava3.core.Single

interface ReposRemoteDataSource {

    fun getRepositories(perPage: Int, page: Int) : Single<List<RepositoryDto>>

}