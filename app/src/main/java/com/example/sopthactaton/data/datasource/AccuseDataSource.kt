package com.example.sopthactaton.data.datasource

import com.example.sopthactaton.api.repo.AccuseApiService
import com.example.sopthactaton.domain.AccuseRepository
import com.example.sopthactaton.model.ResponseCategoryDto
import retrofit2.Response

class AccuseDataSource(private val apiService: AccuseApiService) : AccuseRepository {
    override suspend fun getCategory(): Response<ResponseCategoryDto> =
        apiService.getCategory()

}