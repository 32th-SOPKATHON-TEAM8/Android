package com.example.sopthactaton.data.repoImpl

import com.example.sopthactaton.data.datasource.AccuseDataSource
import com.example.sopthactaton.data.datasource.TestRepoRemoteDataSource
import com.example.sopthactaton.model.ResponseAccuseDto
import com.example.sopthactaton.model.ResponseCategoryDto
import com.example.sopthactaton.model.userId
import retrofit2.Response


class AccuseRepoImpl(
    private val accuseDataSource :AccuseDataSource
){
    suspend fun getCategory(): Response<ResponseCategoryDto> {
        return accuseDataSource.getCategory()
    }

    suspend fun accuse(userId: Int): Response<ResponseAccuseDto> {
        return accuseDataSource.accuse(userId)
    }
}