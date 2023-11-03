package com.example.domain.gateways

import com.example.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface UsersGateway {

    fun signIn(token: String): Flow<Resource<Unit>>

}