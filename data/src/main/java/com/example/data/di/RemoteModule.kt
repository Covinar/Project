package com.example.data.di

import com.example.data.api.ApiConstants
import com.example.data.api.ApiService
import com.example.data.api.AuthInterceptor
import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.remote.AuthRemoteDataSource
import com.example.data.datasources.remote.AuthRemoteDataSourceImpl
import com.example.data.datasources.remote.ReposRemoteDataSource
import com.example.data.datasources.remote.ReposRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideAuthInterceptor(authLocalDataSource: AuthLocalDataSource) = AuthInterceptor(authLocalDataSource)

    @Provides
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create()
    }

    @Provides
    fun provideAuthRemoteDataSource(apiService: ApiService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(apiService)

    @Provides
    fun provideReposRemoteDataSource(apiService: ApiService): ReposRemoteDataSource = ReposRemoteDataSourceImpl(apiService)

}