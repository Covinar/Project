package com.example.domain.gateways

import com.example.domain.common.Resource
import com.example.domain.models.repos.Repository
import io.reactivex.rxjava3.core.Observable

interface ReposGateway {

    fun getRepos(perPage: Int, page: Int) : Observable<Resource<List<Repository>>>

}