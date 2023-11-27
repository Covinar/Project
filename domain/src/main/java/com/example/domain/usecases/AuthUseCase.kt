package com.example.domain.usecases

import com.example.domain.common.Resource
import io.reactivex.rxjava3.core.Observable

interface AuthUseCase {

    operator fun invoke(token: String) : Observable<Resource<Unit>>

}