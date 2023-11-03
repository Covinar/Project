package com.example.data.mappers

import com.example.data.dto.RepositoryDto
import com.example.domain.models.Repository

fun RepositoryDto.map() = Repository(name, repositoryPrivate)
