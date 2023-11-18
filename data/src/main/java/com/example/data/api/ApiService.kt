package com.example.data.api

import com.example.data.dto.RepositoryDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConstants.AUTH_URL)
    fun singIn(): Single<Unit>

    @GET(ApiConstants.REPO_URL)
    fun getRepositories(
        @Query(value = "per_page", encoded = true) perPage: Int,
        @Query(value = "page", encoded = true) page: Int
    ): Single<List<RepositoryDto>>

}