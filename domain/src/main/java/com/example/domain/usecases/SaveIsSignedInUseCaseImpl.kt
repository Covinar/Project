package com.example.domain.usecases

import com.example.domain.gateways.AuthGateway
import javax.inject.Inject

class SaveIsSignedInUseCaseImpl @Inject constructor(
    private val authGateway: AuthGateway
) : SaveIsSignedInUseCase {

    override fun invoke(isSignedIn: Boolean) {
        authGateway.saveIsSignedIn(isSignedIn)
    }

}