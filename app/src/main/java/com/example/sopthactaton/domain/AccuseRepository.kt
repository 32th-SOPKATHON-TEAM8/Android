package com.example.sopthactaton.domain

import com.example.sopthactaton.model.ResponseAccuseDto
import com.example.sopthactaton.model.ResponseCategoryDto
import com.example.sopthactaton.model.userId
import retrofit2.Response

interface AccuseRepository {
    suspend fun getCategory(): Response<ResponseCategoryDto>

    suspend fun accuse(uesrId: Int): Response<ResponseAccuseDto>
}