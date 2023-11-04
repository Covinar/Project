package com.example.data.mappers

import com.example.data.dto.RepositoryDto
import com.example.domain.models.Repository

fun RepositoryDto.toRepository() = Repository(name, repositoryPrivate)

fun List<RepositoryDto>.toRepositories() = this.map { it.toRepository() }
