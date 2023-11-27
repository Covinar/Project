package com.example.presentation.repositories

import androidx.lifecycle.ViewModel
import com.example.domain.common.Resource
import com.example.domain.models.repos.RepoItem
import com.example.domain.models.repos.RepoLoading
import com.example.domain.models.repos.Repository
import com.example.domain.usecases.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()
    private var disposable: Disposable? = null

    private var page: Int = 1

    fun onLastItemReached() {
        if (disposable?.isDisposed == false) {
            page++
            getRepos()
        }
    }

    fun getRepos() {
        disposable = getReposUseCase(PER_PAGE, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is Resource.Error -> {
                        it.model?.let {
                            if (it.isEmpty()) {
                                page--
                            }
                            _state.update { s ->
                                s.copy(repositories = s.repositories.filterIsInstance<Repository>() + it)
                            }
                        }
                    }

                    is Resource.Loading -> _state.update { s ->
                        s.copy(repositories = s.repositories + RepoLoading)
                    }

                    is Resource.Success -> {
                        if (it.model.isEmpty()) {
                            page--
                        }
                        _state.update { s ->
                            s.copy(repositories = s.repositories.filterIsInstance<Repository>() + it.model)
                        }
                    }
                }
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    data class State(
        val repositories: List<RepoItem> = emptyList()
    )

    companion object {
        private const val PER_PAGE = 5
    }

}