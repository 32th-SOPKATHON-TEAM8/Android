package com.example.sopthactaton.api

import com.example.sopthactaton.model.ResponseAccuseDto
import com.example.sopthactaton.model.ResponseCategoryDto
import com.example.sopthactaton.model.userId
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface AccuseApiService {
    @GET("category")
    suspend fun getCategory(): Response<ResponseCategoryDto>
    @PATCH("report")
    suspend fun accuse(@Body userId : Int): Response<ResponseAccuseDto>
}