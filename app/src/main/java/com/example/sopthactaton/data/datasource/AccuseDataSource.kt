package com.example.sopthactaton.data.datasource

import com.example.sopthactaton.api.AccuseApiService
import com.example.sopthactaton.domain.AccuseRepository
import com.example.sopthactaton.model.ResponseAccuseDto
import com.example.sopthactaton.model.ResponseCategoryDto
import com.example.sopthactaton.model.userId
import retrofit2.Response

class AccuseDataSource(private val apiService: AccuseApiService) : AccuseRepository {
    override suspend fun getCategory(): Response<ResponseCategoryDto> =
        apiService.getCategory()

    override suspend fun accuse(userId:Int): Response<ResponseAccuseDto> =
        apiService.accuse(userId)


}