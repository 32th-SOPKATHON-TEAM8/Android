package com.example.sopthactaton.api.model

import android.provider.ContactsContract.CommonDataKinds.Nickname
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRankingDto(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Data>

) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int,
        @SerialName("nickname")
        val nickname: String,
        @SerialName("life")
        val life: Int,
        @SerialName("isHost")
        val isHost: Boolean
    )
}