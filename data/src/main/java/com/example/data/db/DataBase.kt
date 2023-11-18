package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RepositoryEntity::class], version = 1, exportSchema = true)
abstract class DataBase : RoomDatabase() {

    abstract fun getDao() : Dao

    companion object {

        fun getDb(context: Context) : DataBase {
            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                "repositories.db"
            ).build()
        }

    }

}