package com.example.presentation.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Repository
import com.example.presentation.R

class RepositoryAdapter(private val items: List<Repository>) : RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RepositoryViewHolder(inflater.inflate(R.layout.repository_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = items[position]
        val tvName: AppCompatTextView = holder.itemView.findViewById(R.id.tv_repository_name)
        val tvPrivate: AppCompatTextView = holder.itemView.findViewById(R.id.tv_repository_private)
        tvName.text = repository.name
        tvPrivate.text = repository.repositoryPrivate
    }
}