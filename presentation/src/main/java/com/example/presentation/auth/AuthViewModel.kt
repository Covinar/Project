package com.example.presentation.auth

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.usecases.AuthUseCase
import com.example.domain.usecases.IsSignedInUseCase
import com.example.domain.usecases.SaveIsSignedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val isSignedInUseCase: IsSignedInUseCase,
    private val saveIsSignedInUseCase: SaveIsSignedInUseCase
) : ViewModel() {

    fun signIn(userName: String, password: String) {
        authUseCase(password)
            .flowOn(Dispatchers.IO)
            .onEach {
                when (it) {
                    is Resource.Error -> {
                        Log.d("TEST", it.exception.message.toString())
                    }
                    is Resource.Loading -> {
                        Log.d("TEST", "Loading")
                    }
                    is Resource.Success ->  {
                        saveIsSignedInUseCase(true)
                        Log.d("TEST", "Success")
                    }
                }
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }

    fun isSignedIn() : Boolean {
        return isSignedInUseCase()
    }

    fun checkInputs(userName: String, password: String): Boolean {
        return userName.isEmpty() || password.isEmpty()
    }

}