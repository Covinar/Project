package com.example.domain.usecases

import com.example.domain.gateways.AuthGateway
import javax.inject.Inject

class IsSignedInUseCaseImpl @Inject constructor(
    private val authGateway: AuthGateway
) : IsSignedInUseCase {

    override fun invoke(): Boolean {
        return authGateway.isSignedIn()
    }

}