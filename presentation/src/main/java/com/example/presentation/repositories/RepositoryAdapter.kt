package com.example.presentation.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Repository
import com.example.presentation.databinding.RepositoryItemBinding

class RepositoryAdapter() : RecyclerView.Adapter<RepositoryViewHolder>() {

    private var items: List<Repository> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
       holder.bind(items[position])
    }

    fun updateItems(items: List<Repository>) {
        this.items = items
        notifyDataSetChanged()
    }

}