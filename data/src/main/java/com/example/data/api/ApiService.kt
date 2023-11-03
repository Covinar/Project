package com.example.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConstants.AUTH_URL)
    suspend fun singIn(): Response<Unit>

    @GET(ApiConstants.REPO_URL)
    suspend fun getRepositories()

}