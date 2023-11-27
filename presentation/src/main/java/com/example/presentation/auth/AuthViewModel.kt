package com.example.presentation.auth

import androidx.lifecycle.ViewModel
import com.example.domain.common.Resource
import com.example.domain.usecases.AuthUseCase
import com.example.domain.usecases.IsSignedInUseCase
import com.example.domain.usecases.SaveIsSignedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val isSignedInUseCase: IsSignedInUseCase,
    private val saveIsSignedInUseCase: SaveIsSignedInUseCase
) : ViewModel() {

    private var disposable: Disposable? = null

    fun signIn(userName: String, password: String) {
        disposable = authUseCase(password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is Resource.Error -> {
                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Success ->  {
                        saveIsSignedInUseCase(true)
                    }
                }
            }
    }

    fun isSignedIn() : Boolean {
        return isSignedInUseCase()
    }

    fun checkInputs(userName: String, password: String): Boolean {
        return userName.isEmpty() || password.isEmpty()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

}