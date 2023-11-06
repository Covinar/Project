package com.example.presentation.repositories

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Repository
import com.example.presentation.R
import com.example.presentation.databinding.RepositoryItemBinding

class RepositoryViewHolder(
    private val binding: RepositoryItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository) {
        binding.tvRepositoryName.text = repository.name
        binding.tvRepositoryPrivate.text = repository.repositoryPrivate.toString()
    }

}