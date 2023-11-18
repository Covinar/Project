package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.local.AuthLocalDataSourceImpl
import com.example.data.db.Dao
import com.example.data.db.DataBase
import com.example.data.datasources.local.ReposLocalDataSource
import com.example.data.datasources.local.ReposLocalDataSourceImpl
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

    @Provides
    fun provideReposLocalDataSource(dao: Dao) : ReposLocalDataSource = ReposLocalDataSourceImpl(dao)

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "repositories.db").build()
    }

    @Provides
    fun provideDao(dataBase: DataBase) : Dao {
        return dataBase.getDao()
    }

}