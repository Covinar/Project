package com.example.data.datasources.remote

import io.reactivex.rxjava3.core.Single

interface AuthRemoteDataSource {

    fun singIn(): Single<Unit>

}
