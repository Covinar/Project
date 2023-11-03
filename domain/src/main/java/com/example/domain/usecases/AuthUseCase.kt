package com.example.domain.usecases

import com.example.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {

    operator fun invoke(token: String) : Flow<Resource<Unit>>

}