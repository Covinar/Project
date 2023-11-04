package com.example.domain.gateways

import com.example.domain.common.Resource
import com.example.domain.models.Repository
import kotlinx.coroutines.flow.Flow

interface ReposGateway {

    fun getRepos() : Flow<Resource<List<Repository>>>

}