package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepositories(repositories: List<RepositoryEntity>)

    @Query ("SELECT * FROM repositories LIMIT :perPage OFFSET :start")
    fun getAllRepositories(start:Int, perPage:Int) : Single<List<RepositoryEntity>>

    @Query ("DELETE FROM repositories")
    fun removeRepositories()
}