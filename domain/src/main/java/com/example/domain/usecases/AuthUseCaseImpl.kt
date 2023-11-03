package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.gateways.UsersGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val usersGateway: UsersGateway
) : AuthUseCase {

    override fun invoke(token: String): Flow<Resource<Unit>> {
        return usersGateway.signIn(token)
    }

}