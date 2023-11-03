package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.local.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    private const val S_PREF = "s_pref"

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(S_PREF, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideAuthLocalDataSource(sPref: SharedPreferences) : AuthLocalDataSource = AuthLocalDataSourceImpl(sPref)

}