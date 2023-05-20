package com.example.sopthactaton.domain

import com.example.sopthactaton.model.ResponseCategoryDto
import retrofit2.Response

interface AccuseRepository {
    suspend fun getCategory(): Response<ResponseCategoryDto>
}