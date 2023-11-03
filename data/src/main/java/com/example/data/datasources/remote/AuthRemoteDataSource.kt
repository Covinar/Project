package com.example.data.datasources.remote

import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun singIn(): Response<Unit>

}
