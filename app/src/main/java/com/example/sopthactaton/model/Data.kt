package com.example.sopthactaton.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("categories")
    val categories: List<Category>
)