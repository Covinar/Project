package com.example.domain.usecases

interface SaveIsSignedInUseCase {

    operator fun invoke(isSignedIn: Boolean)

}