package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.models.Repository
import kotlinx.coroutines.flow.Flow

interface GetReposUseCase {

    operator fun invoke() : Flow<Resource<List<Repository>>>

}