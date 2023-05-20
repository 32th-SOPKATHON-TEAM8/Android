package com.example.sopthactaton.api.repo

import com.example.sopthactaton.api.TestApiService
import retrofit2.Response

class TestRepoRemoteDataSource(private val apiService: TestApiService) : TestDataSource {
    override suspend fun getMainPage(): Response<Any> =
        apiService.getMainPage()
}