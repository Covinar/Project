package com.example.data.datasources.local

import com.example.data.db.RepositoryEntity
import io.reactivex.rxjava3.core.Single

interface ReposLocalDataSource {

    fun insertRepositories(repositories: List<RepositoryEntity>)

    fun getAllRepositories(start: Int, perPage: Int) : Single<List<RepositoryEntity>>

    fun removeRepositories()

}