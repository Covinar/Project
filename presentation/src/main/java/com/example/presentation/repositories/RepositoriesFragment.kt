package com.example.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentation.common.BaseFragment
import com.example.presentation.databinding.FragmentRepositoriesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class RepositoriesFragment : BaseFragment<FragmentRepositoriesBinding>() {

    private val viewModel: RepositoriesViewModel by viewModels()
    private val repoAdapter = RepositoryAdapter()

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        viewModel.getRepos()
        viewModel.state.onEach {
            repoAdapter.updateItems(it.repositories)
        }.launchIn(lifecycleScope)
    }

    private fun setupAdapter() {
        binding.rvRepos.adapter = repoAdapter
    }

}