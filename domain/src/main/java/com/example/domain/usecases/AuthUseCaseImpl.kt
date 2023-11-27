package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.gateways.AuthGateway
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val authGateway: AuthGateway
) : AuthUseCase {

    override fun invoke(token: String): Observable<Resource<Unit>> {
        return authGateway.signIn(token)
    }

}