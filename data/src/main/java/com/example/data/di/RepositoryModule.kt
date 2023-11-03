package com.example.data.di

import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.remote.AuthRemoteDataSource
import com.example.data.gateways.UsersGatewayImpl
import com.example.domain.gateways.UsersGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUsersRepository(
        authLocalDataSource: AuthLocalDataSource,
        authRemoteDataSource: AuthRemoteDataSource
    ): UsersGateway = UsersGatewayImpl(authLocalDataSource, authRemoteDataSource)

}