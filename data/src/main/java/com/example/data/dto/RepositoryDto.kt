package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class RepositoryDto(
    val name: String,
    @SerializedName("private")
    val repositoryPrivate: String
) {

}
