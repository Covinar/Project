package com.example.domain.gateways

import com.example.domain.common.Resource
import io.reactivex.rxjava3.core.Observable

interface AuthGateway {

    fun signIn(token: String): Observable<Resource<Unit>>

    fun saveIsSignedIn(isSignedIn: Boolean)

    fun isSignedIn(): Boolean

}