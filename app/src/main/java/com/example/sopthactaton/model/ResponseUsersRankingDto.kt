package com.example.sopthactaton.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUsersRankingDto(
    @SerialName("data")
    val data: Data,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: Int
) {
    @Serializable
    data class Data(
        @SerialName("penalty")
        val penalty: String,
        @SerialName("user")
        val user: List<User>
    ) {
        @Serializable
        data class User(
            @SerialName("id")
            val id: Int,
            @SerialName("host")
            val isHost: Boolean,
            @SerialName("life")
            val life: Int,
            @SerialName("nickname")
            val nickname: String
        )
    }
}