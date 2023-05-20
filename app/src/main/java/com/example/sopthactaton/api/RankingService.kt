package com.example.sopthactaton.api

import com.example.sopthactaton.api.model.ResponseRankingDto
import retrofit2.Call
import retrofit2.http.GET

interface RankingService {
    @GET("get")
    fun rank(
    ): Call<ResponseRankingDto>
}