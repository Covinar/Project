package com.example.presentation.repositories

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.repos.Repository
import com.example.presentation.R
import com.example.presentation.databinding.RepositoryItemBinding

class RepositoryViewHolder(
    private val binding: RepositoryItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository) {
        binding.tvRepositoryName.text = repository.name
        binding.tvRepositoryPrivate.text = repository.isPrivate.toString()
        if (repository.isPrivate) {
            binding.tvRepositoryPrivate.setTextColor(itemView.context.getColor(R.color.red))
        } else {
            binding.tvRepositoryPrivate.setTextColor(itemView.context.getColor(R.color.green))
        }
    }

}