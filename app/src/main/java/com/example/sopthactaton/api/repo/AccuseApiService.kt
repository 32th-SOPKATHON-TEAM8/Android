package com.example.sopthactaton.api.repo

import com.example.sopthactaton.model.ResponseCategoryDto
import retrofit2.Response
import retrofit2.http.GET

interface AccuseApiService {
    @GET("category")
    suspend fun getCategory(): Response<ResponseCategoryDto>
}