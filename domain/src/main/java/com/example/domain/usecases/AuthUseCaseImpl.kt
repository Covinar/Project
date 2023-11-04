package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.gateways.AuthGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val authGateway: AuthGateway
) : AuthUseCase {

    override fun invoke(token: String): Flow<Resource<Unit>> {
        return authGateway.signIn(token)
    }

}