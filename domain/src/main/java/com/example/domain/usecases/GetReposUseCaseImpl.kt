package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.gateways.ReposGateway
import com.example.domain.models.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReposUseCaseImpl @Inject constructor(
    private val reposGateway: ReposGateway
) : GetReposUseCase {
    override fun invoke(): Flow<Resource<List<Repository>>> {
        return reposGateway.getRepos()
    }
}