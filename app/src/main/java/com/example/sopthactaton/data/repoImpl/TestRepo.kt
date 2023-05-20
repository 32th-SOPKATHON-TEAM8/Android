package com.example.sopthactaton.data.repoImpl

import com.example.sopthactaton.data.datasource.TestRepoRemoteDataSource
import com.example.sopthactaton.model.ResponseCategoryDto
import retrofit2.Response

class TestRepo(
    private val testDataSource: TestRepoRemoteDataSource
){
    suspend fun getMainPage():Response<Any> {
        return testDataSource.getMainPage()
    }
}