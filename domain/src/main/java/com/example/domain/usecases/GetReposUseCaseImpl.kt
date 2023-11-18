package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.gateways.ReposGateway
import com.example.domain.models.repos.Repository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetReposUseCaseImpl @Inject constructor(
    private val reposGateway: ReposGateway
) : GetReposUseCase {
    override fun invoke(perPage: Int, page: Int): Observable<Resource<List<Repository>>> {
        return reposGateway.getRepos(perPage, page)
    }
}