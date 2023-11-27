package com.example.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.presentation.R
import com.example.presentation.common.BaseFragment
import com.example.presentation.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = childFragmentManager.findFragmentById(R.id.frag_container2)
        fragment?.let {
            val navController = fragment.findNavController()
            binding.bottomNavigation.setupWithNavController(navController)
        }
    }

}