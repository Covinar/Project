package com.example.presentation.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.repos.RepoItem
import com.example.domain.models.repos.RepoLoading
import com.example.domain.models.repos.Repository
import com.example.presentation.databinding.RepositoryItemBinding
import com.example.presentation.databinding.RepositoryLoadingItemBinding

class RepositoryAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<RepoItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (RepoViewType.values()[viewType]) {
            RepoViewType.REPOSITORY -> RepositoryViewHolder(
                RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            RepoViewType.LOADING -> RepositoryLoadingViewHolder(
                RepositoryLoadingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RepositoryViewHolder) {
            holder.bind(items[position] as Repository)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is Repository -> RepoViewType.REPOSITORY.ordinal
            RepoLoading -> RepoViewType.LOADING.ordinal
        }
    }

    fun updateItems(items: List<RepoItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    enum class RepoViewType {
        REPOSITORY, LOADING
    }

}