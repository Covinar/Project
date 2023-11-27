package com.example.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
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
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvRepos.layoutManager = linearLayoutManager
        binding.rvRepos.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (
                    linearLayoutManager.findLastVisibleItemPosition() == viewModel.state.value.repositories.lastIndex &&
                    linearLayoutManager.findLastVisibleItemPosition() > 3
                ) {
                    viewModel.onLastItemReached()
                }
            }
        })
    }

}