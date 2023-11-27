package com.example.domain.di

import com.example.domain.gateways.AuthGateway
import com.example.domain.gateways.ReposGateway
import com.example.domain.usecases.AuthUseCase
import com.example.domain.usecases.AuthUseCaseImpl
import com.example.domain.usecases.GetReposUseCase
import com.example.domain.usecases.GetReposUseCaseImpl
import com.example.domain.usecases.IsSignedInUseCase
import com.example.domain.usecases.IsSignedInUseCaseImpl
import com.example.domain.usecases.SaveIsSignedInUseCase
import com.example.domain.usecases.SaveIsSignedInUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideSaveIsSignedInUseCase(authGateway: AuthGateway): SaveIsSignedInUseCase = SaveIsSignedInUseCaseImpl(authGateway)

    @Provides
    fun provideIsSignedInUseCase(authGateway: AuthGateway): IsSignedInUseCase = IsSignedInUseCaseImpl(authGateway)

    @Provides
    fun provideAuthUseCase(authGateway: AuthGateway): AuthUseCase = AuthUseCaseImpl(authGateway)

    @Provides
    fun provideGetReposUseCase(reposGateway: ReposGateway): GetReposUseCase = GetReposUseCaseImpl(reposGateway)

}