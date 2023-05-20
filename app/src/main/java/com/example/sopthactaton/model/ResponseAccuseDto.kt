package com.example.sopthactaton.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccuseDto(
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: Int
)