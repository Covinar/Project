package com.example.data.di

import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.local.ReposLocalDataSource
import com.example.data.datasources.remote.AuthRemoteDataSource
import com.example.data.datasources.remote.ReposRemoteDataSource
import com.example.data.gateways.AuthGatewayImpl
import com.example.data.gateways.ReposGatewayImpl
import com.example.domain.gateways.AuthGateway
import com.example.domain.gateways.ReposGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authLocalDataSource: AuthLocalDataSource,
        authRemoteDataSource: AuthRemoteDataSource
    ): AuthGateway =
        AuthGatewayImpl(authLocalDataSource, authRemoteDataSource)

    @Provides
    fun provideReposRepository(
        reposLocalDataSource: ReposLocalDataSource,
        reposRemoteDataSource: ReposRemoteDataSource
    ): ReposGateway =
        ReposGatewayImpl(reposLocalDataSource, reposRemoteDataSource)

}