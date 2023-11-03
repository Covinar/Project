package com.example.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.presentation.databinding.FragmentRepositoriesBinding
import java.lang.RuntimeException

class RepositoriesFragment : Fragment() {

    private var _binding: FragmentRepositoriesBinding? = null
    private val binding: FragmentRepositoriesBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}