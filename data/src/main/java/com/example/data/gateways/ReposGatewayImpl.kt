package com.example.data.gateways

import com.example.data.datasources.local.ReposLocalDataSource
import com.example.data.datasources.remote.ReposRemoteDataSource
import com.example.data.mappers.toRepositories
import com.example.domain.common.Resource
import com.example.domain.gateways.ReposGateway
import com.example.domain.models.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReposGatewayImpl @Inject constructor(
    private val reposLocalDataSource: ReposLocalDataSource,
    private val reposRemoteDataSource: ReposRemoteDataSource
) : ReposGateway {
    override fun getRepos(): Flow<Resource<List<Repository>>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = reposRemoteDataSource.getRepositories()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it.toRepositories()))
                    }
                } else {
                    val er = response.errorBody().toString()
                    emit(Resource.Error(Exception(er)))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e))
            }
        }
    }
}

