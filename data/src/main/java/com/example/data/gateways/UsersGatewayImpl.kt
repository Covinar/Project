package com.example.data.gateways

import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.remote.AuthRemoteDataSource
import com.example.domain.common.Resource
import com.example.domain.gateways.UsersGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersGatewayImpl @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) : UsersGateway {

    override fun signIn(token: String): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading)
            authLocalDataSource.saveToken(token)
            try {
                val response = authRemoteDataSource.singIn()
                if (response.isSuccessful) {
                    emit(Resource.Success(Unit))
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