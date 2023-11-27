package com.example.domain.usecases

import com.example.domain.common.Resource
import com.example.domain.models.repos.Repository
import io.reactivex.rxjava3.core.Observable

interface GetReposUseCase {

    operator fun invoke(perPage: Int, page: Int) : Observable<Resource<List<Repository>>>

}