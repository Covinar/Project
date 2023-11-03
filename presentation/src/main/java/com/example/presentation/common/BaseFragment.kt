package com.example.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T: ViewBinding>: Fragment() {

    var _binding: T? = null
    val binding: T
        get() = _binding ?: throw RuntimeException("Binding is null")

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createBinding(inflater, container)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}