package com.example.data.gateways

import com.example.data.datasources.local.AuthLocalDataSource
import com.example.data.datasources.remote.AuthRemoteDataSource
import com.example.domain.common.Resource
import com.example.domain.gateways.AuthGateway
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthGatewayImpl @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthGateway {

    override fun signIn(token: String): Observable<Resource<Unit>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.Loading)
            authLocalDataSource.saveToken(token)
            val disposable = authRemoteDataSource.singIn()
                .subscribe({
                          emitter.onNext(Resource.Success(Unit))
                },{
                    emitter.onNext(Resource.Error(Exception(it)))
                })
        }
    }

    override fun saveIsSignedIn(isSignedIn: Boolean) {
        authLocalDataSource.saveIsSignedIn(isSignedIn)
    }

    override fun isSignedIn(): Boolean {
        return authLocalDataSource.isSignedIn()
    }

}