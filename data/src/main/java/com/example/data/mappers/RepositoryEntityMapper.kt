package com.example.data.mappers

import com.example.data.db.RepositoryEntity
import com.example.domain.models.repos.Repository

fun RepositoryEntity.toRepository() = Repository(name, isPrivate)

fun List<RepositoryEntity>.toRepositories() = this.map { it.toRepository() }
