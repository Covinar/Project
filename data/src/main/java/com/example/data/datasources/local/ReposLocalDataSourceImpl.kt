package com.example.data.datasources.local

import com.example.data.db.Dao
import com.example.data.db.RepositoryEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ReposLocalDataSourceImpl @Inject constructor(
    private val dao: Dao
) : ReposLocalDataSource {
    override fun insertRepositories(repositories: List<RepositoryEntity>) {
        dao.insertRepositories(repositories)
    }

    override fun getAllRepositories(start: Int, perPage: Int): Single<List<RepositoryEntity>> {
        return dao.getAllRepositories(start, perPage)
    }

    override fun removeRepositories() {
        dao.removeRepositories()
    }

}