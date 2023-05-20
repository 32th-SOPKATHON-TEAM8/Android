package com.example.sopthactaton.data.datasource

import com.example.sopthactaton.api.TestApiService
import com.example.sopthactaton.domain.TestDataSource
import retrofit2.Response

class TestRepoRemoteDataSource(private val apiService: TestApiService) : TestDataSource {
    override suspend fun getMainPage(): Response<Any> =
        apiService.getMainPage()
}