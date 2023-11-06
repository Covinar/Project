package com.example.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.common.BaseFragment
import com.example.presentation.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding>() {

    private val viewModel: AuthViewModel by viewModels()

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.isSignedIn()){
            val navController = findNavController()
            navController.navigate(AuthFragmentDirections.actionAuthFragment2ToMainFragment2())
        }
        listeners()
    }

    private fun listeners() {
        binding.btnSignIn.setOnClickListener {
            if (viewModel.checkInputs(binding.etUsername.text.toString(), binding.etPassword.text.toString())) {
                Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.signIn(binding.etUsername.text.toString(), binding.etPassword.text.toString())
                val navController = findNavController()
                navController.navigate(AuthFragmentDirections.actionAuthFragment2ToMainFragment2())
            }
        }
    }

}