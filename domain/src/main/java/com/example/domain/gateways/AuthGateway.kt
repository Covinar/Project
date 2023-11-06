package com.example.domain.gateways

import com.example.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface AuthGateway {

    fun signIn(token: String): Flow<Resource<Unit>>

    fun saveIsSignedIn(isSignedIn: Boolean)

    fun isSignedIn(): Boolean

}