package com.example.domain.di

import com.example.domain.gateways.AuthGateway
import com.example.domain.usecases.AuthUseCase
import com.example.domain.usecases.AuthUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideAuthUseCase(usersGateway: AuthGateway): AuthUseCase = AuthUseCaseImpl(usersGateway)

}