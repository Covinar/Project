package com.example.data.gateways

import com.example.data.datasources.local.ReposLocalDataSource
import com.example.data.datasources.remote.ReposRemoteDataSource
import com.example.data.mappers.toEntities
import com.example.data.mappers.toRepositories
import com.example.domain.common.Resource
import com.example.domain.gateways.ReposGateway
import com.example.domain.models.repos.Repository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ReposGatewayImpl @Inject constructor(
    private val reposLocalDataSource: ReposLocalDataSource,
    private val reposRemoteDataSource: ReposRemoteDataSource
) : ReposGateway {
    override fun getRepos(perPage: Int, page: Int): Observable<Resource<List<Repository>>> {
        return Observable.create { emitter ->
            val start = perPage * (page-1)
            emitter.onNext(Resource.Loading)
            val disposable = reposRemoteDataSource.getRepositories(perPage, page)
                .subscribe({
                    if (page == 1) {
                        reposLocalDataSource.removeRepositories()
                    }
                    reposLocalDataSource.insertRepositories(it.toEntities())
                    emitter.onNext(Resource.Success(it.toRepositories()))
                },{
                    val disposable = reposLocalDataSource.getAllRepositories(start, perPage)
                        .subscribe { items ->
                            emitter.onNext(Resource.Error(Exception(it), items.toRepositories()))
                        }
                })


        }
    }
}

