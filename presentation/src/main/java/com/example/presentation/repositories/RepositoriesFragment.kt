package com.example.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.presentation.common.BaseFragment
import com.example.presentation.databinding.FragmentRepositoriesBinding

class RepositoriesFragment : BaseFragment<FragmentRepositoriesBinding>() {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}