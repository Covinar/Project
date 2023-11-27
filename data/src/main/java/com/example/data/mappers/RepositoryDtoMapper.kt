package com.example.data.mappers

import com.example.data.db.RepositoryEntity
import com.example.data.dto.RepositoryDto
import com.example.domain.models.repos.Repository

fun RepositoryDto.toRepository() = Repository(name, isPrivate)
fun RepositoryDto.toEntity() = RepositoryEntity(null, name, isPrivate)
fun List<RepositoryDto>.toRepositories() = this.map { it.toRepository() }
fun List<RepositoryDto>.toEntities() = this.map { it.toEntity() }
