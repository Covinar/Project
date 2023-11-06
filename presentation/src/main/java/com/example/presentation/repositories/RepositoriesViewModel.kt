package com.example.presentation.repositories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.models.Repository
import com.example.domain.usecases.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun getRepos() {
        getReposUseCase()
            .flowOn(Dispatchers.IO)
            .onEach {
                when(it) {
                    is Resource.Error -> Log.d("TEST", it.exception.message.toString())
                    is Resource.Loading -> Log.d("TEST", "Loading")
                    is Resource.Success -> _state.update { s ->
                        s.copy(repositories = it.model)
                    }
                }
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }

    data class State(
        val repositories: List<Repository> = emptyList()
    )

}